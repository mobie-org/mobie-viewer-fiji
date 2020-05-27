package de.embl.cba.mobie.command;

import de.embl.cba.mobie.viewer.MoBIEViewer;
import net.imagej.ImageJ;
import org.scijava.command.Command;
import org.scijava.plugin.Parameter;
import org.scijava.plugin.Plugin;


@Plugin(type = Command.class, menuPath = "Plugins>MoBIE>View Datasets..." )
public class OpenMoBIEViewerCommand implements Command
{
	@Parameter ( label = "Images Location", style = "directory" )
	public String imagesLocation = "/Volumes/arendt/EM_6dpf_segmentation/platy-browser-data/data";

	@Parameter ( label = "Tables Location" )
	public String tablesLocation = "/Volumes/arendt/EM_6dpf_segmentation/platy-browser-data/data";

	@Override
	public void run()
	{
		final MoBIEViewer moBIEViewer = new MoBIEViewer(
				imagesLocation,
				tablesLocation );
	}

	public static void main(final String... args)
	{
		final ImageJ ij = new ImageJ();
		ij.ui().showUI();

		ij.command().run( OpenMoBIEViewerCommand.class, true );
	}
}