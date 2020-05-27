package repos;

import de.embl.cba.mobie.viewer.MoBIEViewer;
import de.embl.cba.mobie.viewer.ViewerOptions;

public class OpenPlatynereisNewBranch
{
	public static void main( String[] args )
	{
		final MoBIEViewer moBIEViewer = new MoBIEViewer(
				"https://github.com/platybrowser/platybrowser",
				"https://github.com/platybrowser/platybrowser",
				ViewerOptions.options().gitBranch( "mobie" ) );
	}
}