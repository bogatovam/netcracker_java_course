package com.netcracker;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Arrays;

@Path("/calc")
public class CalculationRestService {
    @GET
    @Path("/add/{first}/{second}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addition(
            @PathParam("first") Double first,
            @PathParam("second") Double second) {
        return new Response(
                Arrays.asList(first, second),
                Response.Operations.ADD,
                first + second);
    }

    @GET
    @Path("/add/{first}/{second}")
    @Produces(MediaType.TEXT_PLAIN)
    public String additionText(
            @PathParam("first") Double first,
            @PathParam("second") Double second) {
        Double result = first + second;
        return first + " + " + second + " = " + result;
    }

    @GET
    @Path("/add/{first}/{second}")
    @Produces(MediaType.TEXT_HTML)
    public String additionHtml(
            @PathParam("first") Double first,
            @PathParam("second") Double second) {
        Double result = first + second;
        return "<h1>" + first + " + " + second + " = " + result + "</h1>";
    }

    @GET
    @Path("/sub/{first}/{second}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response subtraction(
            @PathParam("first") Double first,
            @PathParam("second") Double second) {
        return new Response(
                Arrays.asList(first, second),
                Response.Operations.SUB,
                first - second);
    }

    @GET
    @Path("/sub/{first}/{second}")
    @Produces(MediaType.TEXT_PLAIN)
    public String subtractionText(
            @PathParam("first") Double first,
            @PathParam("second") Double second) {
        Double result = first - second;
        return first + " - " + second + " = " + result;
    }

    @GET
    @Path("/sub/{first}/{second}")
    @Produces(MediaType.TEXT_HTML)
    public String subtractionHtml(
            @PathParam("first") Double first,
            @PathParam("second") Double second) {
        Double result = first - second;
        return "<h1>" + first + " - " + second + " = " + result + "</h1>";
    }

    @GET
    @Path("/mult/{first}/{second}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response multiplications(
            @PathParam("first") Double first,
            @PathParam("second") Double second) {
        return new Response(
                Arrays.asList(first, second),
                Response.Operations.MULT,
                first * second);
    }

    @GET
    @Path("/mult/{first}/{second}")
    @Produces(MediaType.TEXT_PLAIN)
    public String multiplicationsText(
            @PathParam("first") Double first,
            @PathParam("second") Double second) {
        Double result = first * second;
        return first + " * " + second + " = " + result;
    }

    @GET
    @Path("/mult/{first}/{second}")
    @Produces(MediaType.TEXT_HTML)
    public String multiplicationsHtml(
            @PathParam("first") Double first,
            @PathParam("second") Double second) {
        Double result = first * second;
        return "<h1>" + first + " * " + second + " = " + result + "</h1>";
    }

    @GET
    @Path("/div/{first}/{second}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response division(
            @PathParam("first") Double first,
            @PathParam("second") Double second) {
        return new Response(
                Arrays.asList(first, second),
                Response.Operations.DIV,
                first / second);
    }

    @GET
    @Path("/div/{first}/{second}")
    @Produces(MediaType.TEXT_PLAIN)
    public String divisionText(
            @PathParam("first") Double first,
            @PathParam("second") Double second) {
        Double result = first / second;
        return first + " / " + second + " = " + result;
    }

    @GET
    @Path("/div/{first}/{second}")
    @Produces(MediaType.TEXT_HTML)
    public String divisionHtml(
            @PathParam("first") Double first,
            @PathParam("second") Double second) {
        Double result = first / second;
        return "<h1>" + first + " / " + second + " = " + result + "</h1>";
    }
}
