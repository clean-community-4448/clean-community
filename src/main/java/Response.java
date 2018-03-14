public class Response {
    private boolean success;
    private String message;

    public Response(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }

    public static Response getBadPermissionsResponse() {
        return new Response(false, "Bad Permissions");
    }

    public static Response getSuccessResponse() {
        return new Response(true, "Success");
    }

    public static Response getServerErrorResponse() {
        return new Response(false, "Server Error");
    }
}
