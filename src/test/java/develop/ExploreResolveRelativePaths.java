package develop;

import org.janelia.saalfeldlab.n5.s3.N5AmazonS3Reader;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ExploreResolveRelativePaths
{
	public static void main( String[] args )
	{
		final Path path = Paths.get( "/Volumes/data/0.2.1/tableA.csv" );
		final Path link = Paths.get( "../../0.2.0/tableB.csv" );

		final Path resolve = path.resolve( link );
		System.out.println( resolve );

		final Path normalize = resolve.normalize();
		System.out.println( normalize );
	}
}
