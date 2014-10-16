package seguridadjee.blog.exception;

public class AppException extends RuntimeException {
	private static final long serialVersionUID = -2876543542270260385L;

	public AppException(Throwable e) {
		super(e);
	}
}
