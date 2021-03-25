package de.embl.cba.mobie2.view;

import de.embl.cba.mobie.Constants;
import de.embl.cba.mobie2.display.SegmentationDisplay;
import de.embl.cba.mobie2.select.SelectionModelAndLabelAdapter;
import de.embl.cba.tables.imagesegment.LabelFrameAndImage;
import de.embl.cba.tables.imagesegment.SegmentUtils;
import de.embl.cba.tables.tablerow.TableRowImageSegment;

import java.util.HashMap;

public class ViewerHelper
{
	public static void showInScatterPlotViewer( SegmentationDisplay display )
	{
		display.scatterPlotViewer = new ScatterPlotViewer<>( display.segments, display.selectionModel, display.coloringModel, new String[]{ Constants.ANCHOR_X, Constants.ANCHOR_Y }, new double[]{1.0, 1.0}, 1.0 );
		display.scatterPlotViewer.show( display.imageViewer.getBdvHandle().getViewerPanel() );
		display.selectionModel.listeners().add( display.scatterPlotViewer );
		display.coloringModel.listeners().add( display.scatterPlotViewer );
		display.imageViewer.getBdvHandle().getViewerPanel().addTimePointListener( display.scatterPlotViewer );
	}

	public static void showInTableViewer( SegmentationDisplay display  )
	{
		display.tableViewer = new TableViewer<>( display.segments, display.selectionModel, display.coloringModel, display.name );
		display.tableViewer.show( display.imageViewer.getBdvHandle().getViewerPanel() );
		display.selectionModel.listeners().add( display.tableViewer );
		display.coloringModel.listeners().add( display.tableViewer );
	}

	public static void showInImageViewer( SegmentationDisplay display )
	{
		final HashMap< LabelFrameAndImage, TableRowImageSegment > labelToSegmentAdapter = SegmentUtils.createSegmentMap( display.segments );
		final SelectionModelAndLabelAdapter selectionModelAndAdapter = new SelectionModelAndLabelAdapter( display.selectionModel, labelToSegmentAdapter );
		display.sourceAndConverters = display.imageViewer.show( display, display.coloringModel, selectionModelAndAdapter );
		display.selectionModel.listeners().add( display.imageViewer );
		display.coloringModel.listeners().add( display.imageViewer );
	}
}