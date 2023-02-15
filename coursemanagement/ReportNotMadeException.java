package coursemanagement;

public class ReportNotMadeException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ReportNotMadeException() {
		super("Report not generated");
		
	}
	
}
