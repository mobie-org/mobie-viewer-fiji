package projects;

import de.embl.cba.mobie.MoBIE;
import de.embl.cba.mobie.MoBIESettings;
import de.embl.cba.mobie.source.ImageDataFormat;
import net.imagej.ImageJ;

import java.io.IOException;

public class OpenLocalJulianNoTables
{
	public static void main( String[] args ) throws IOException
	{
		final ImageJ imageJ = new ImageJ();
		imageJ.ui().showUI();
		final MoBIE moBIE2 = new MoBIE("/Volumes/emcf/hennies/for_constantin/mobie_no_table_test/", MoBIESettings.settings().imageDataFormat( ImageDataFormat.BdvN5 ));
	}
}
