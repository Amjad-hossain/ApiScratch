package org.codehaven.userapi.resource;

import org.codehaven.userapi.dto.UserDto;
import org.codehaven.userapi.service.UserService;
import com.wordnik.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;

/**
 * Created by amjad on 7/3/15.
 */

@Path("/v1/usr")
@Api(value="/User", description = "User & User Source Related Operations")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
@Component
public class UserResource {

    private static final Logger logger = LoggerFactory.getLogger(UserResource.class);

    @Context
    private UriInfo uriInfo;

    @Inject
    private UserService userService;

    @GET
    @ApiOperation(value = "Get User(s)", notes = "List of all uers", position = 1)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retrieval Successful"),
            @ApiResponse(code = 204, message = "No Content")})
    public Response readUser(@ApiParam(value = "User Id") @QueryParam("userId") Long userId) throws Exception {

        List<UserDto> userDtoList = userService.getUserDtoList(userId);
        return Response.status(Response.Status.OK).entity(userDtoList).build();
    }

    @POST
    @ApiOperation(value = "Create User", notes = "Create user", position = 2)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Create user Successful"),
            @ApiResponse(code = 204, message = "No Content")})
    public Response createUser(@ApiParam(value = "User Dto" , required = true) UserDto userDto) throws Exception {

        logger.info(">>> createUser:: userService.createUser(userDto);");
        UserDto soredUserDto = userService.createUser(userDto);
        logger.info("<<< createUser:: [{}]User saved successfully", soredUserDto .getId());
        return Response.status(Response.Status.OK).entity(soredUserDto).build();
    }

    @PUT
    @Path("/{userId}")
    @ApiOperation(value = "Update User", notes = "Update user", position = 3)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Update user Successful"),
            @ApiResponse(code = 204, message = "No Content")})
    public Response updateUser(@ApiParam(value = "User Id" , required = true)  @PathParam("userId") Long userId,
                               @ApiParam(value = "User Dto" , required = true) UserDto userDto) throws Exception {

        userService.modifyUser(userId, userDto);
        return Response.status(Response.Status.OK).build();
    }

    @DELETE
    @Path("/{userId}")
    @ApiOperation(value = "Update User", notes = "Update user", position = 3)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Update user Successful"),
            @ApiResponse(code = 204, message = "No Content")})
    public Response updateUser(@ApiParam(value = "User Id" , required = true)  @PathParam("userId") Long userId) throws Exception {

        userService.deleteUser(userId);
        return Response.status(Response.Status.OK).build();
    }
}
