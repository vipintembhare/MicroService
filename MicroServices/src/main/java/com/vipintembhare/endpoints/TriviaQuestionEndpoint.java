package com.vipintembhare.endpoints;

import java.util.Date;
import java.util.List;

import javax.websocket.server.PathParam;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.vipintembhare.TriviaQuestion;
import com.vipintembhare.dao.*;

@Path("/questions")
public class TriviaQuestionEndpoint {

	final private TriviaQuestionAccessible dataAccess= new TriviaQuestionArrayAccess();
	private static final int STARTING_OFFSET=0;
	private static final int PAGE_SIZE=10;
	final private Date questionUpdatedDate= new Date();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getQuestions(@Context UriInfo uri,
								 @QueryParam("offset") @DefaultValue("0") long offset) {
		long datasetSize =dataAccess.getQuestionListSize();
		long start= offset;
		if(start<0) {
			start=0;
		}
		if(start >= datasetSize) {
			start=datasetSize;
		}
		
		//Setup navigation links
		Link selfLink = Link.fromUri(uri.getBaseUri()+"questions?offset={offset}")
							.rel("self")
							.type(MediaType.APPLICATION_JSON)
							.build(offset);
		
		long nextOffset= offset+PAGE_SIZE < datasetSize? offset+PAGE_SIZE:datasetSize;
		Link nextLink = Link.fromUri(uri.getBaseUri()+"questions?offset={offset}")
				.rel("next")
				.type(MediaType.APPLICATION_JSON)
				.build(nextOffset);
		
		long prevOffset= offset-PAGE_SIZE < STARTING_OFFSET? offset-PAGE_SIZE :STARTING_OFFSET;
		Link prevLink = Link.fromUri(uri.getBaseUri()+"questions?offset={offset}")
				.rel("prev")
				.type(MediaType.APPLICATION_JSON)
				.build(prevOffset);		
		
		Link firstLink = Link.fromUri(uri.getBaseUri()+"questions?offset={offset}")
				.rel("first")
				.type(MediaType.APPLICATION_JSON)
				.build(STARTING_OFFSET);
		
		Link lastLink = Link.fromUri(uri.getBaseUri()+"questions?offset={offset}")
				.rel("last")
				.type(MediaType.APPLICATION_JSON)
				.build(datasetSize);
		Link countLink = Link.fromUri(uri.getBaseUri()+"questionset/count")
				.rel("count")
				.type(MediaType.APPLICATION_JSON)
				.build();
		
		Link randomLink = Link.fromUri(uri.getBaseUri()+"questions/random")
				.rel("random")
				.type(MediaType.APPLICATION_JSON)
				.build();
		List<TriviaQuestion> list= dataAccess.getQuestionList(start);
		return Response.ok(list)
						.header("question-count",datasetSize)
						.header("current-question-list-size",list.size())
						.header("offset",start)
						.links(selfLink,nextLink,prevLink,firstLink,lastLink,countLink,randomLink)
						.lastModified(questionUpdatedDate)
						.location(uri.getRequestUri())
						.build();
	}

	@GET
	@Path("count")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getQuestionsCount(@Context UriInfo uri) {
		long numberOfQuestions = dataAccess.getQuestionListSize();
		return Response.ok(numberOfQuestions)
				.header("question-count",numberOfQuestions)
				.lastModified(questionUpdatedDate)
				.location(uri.getRequestUri())
				.build();
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getQuestion(@Context UriInfo uri, @PathParam("id") String idString) {
		Response response;
		if(null != idString && idString.trim().equalsIgnoreCase("random")) {
			TriviaQuestion question= dataAccess.getRandomQuestion();
			response =Response.ok(question)
					.lastModified(question.getLastUpdated())
					.location(uri.getRequestUri())
					.build();
		}else {
			try {
				long id= Long.parseLong(idString);
				if(id>=dataAccess.getQuestionListSize()) {
					response= Response.status(Response.Status.BAD_REQUEST).build();
				}else {
					TriviaQuestion question= dataAccess.getQuestionById(id);
					response =Response.ok(question)
							.lastModified(question.getLastUpdated())
							.location(uri.getRequestUri())
							.build();
				}
			}
			catch(NumberFormatException e) {
				response= Response.status(Response.Status.BAD_REQUEST).build();
			}
		}
		return response;
	}

}
