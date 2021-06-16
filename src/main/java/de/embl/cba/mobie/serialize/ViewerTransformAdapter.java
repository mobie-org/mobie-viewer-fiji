package de.embl.cba.mobie.serialize;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.reflect.TypeToken;
import de.embl.cba.mobie.transform.AffineSourceTransformer;
import de.embl.cba.mobie.transform.CropSourceTransformer;
import de.embl.cba.mobie.transform.GridSourceTransformer;
import de.embl.cba.mobie.transform.NormalizedAffineViewerTransform;
import de.embl.cba.mobie.transform.SourceTransformer;
import de.embl.cba.mobie.transform.AffineViewerTransform;
import de.embl.cba.mobie.transform.ViewerTransform;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ViewerTransformAdapter implements JsonSerializer< ViewerTransform >, JsonDeserializer< ViewerTransform >
{
	private static Map<String, Class> nameToClass = new TreeMap<>();
	private static Map<String, String> classToName = new TreeMap<>();

	static {
		nameToClass.put("affine", AffineViewerTransform.class);
		classToName.put(GridSourceTransformer.class.getName(), "grid");
		nameToClass.put("normalizedAffine", NormalizedAffineViewerTransform.class);
		classToName.put(AffineSourceTransformer.class.getName(), "affine");
		nameToClass.put("position", CropSourceTransformer.class);
		classToName.put(CropSourceTransformer.class.getName(), "crop");
	}

	@Override
	public ViewerTransform deserialize( JsonElement json, Type typeOfT, JsonDeserializationContext context ) throws JsonParseException
	{
		final ViewerTransform viewerTransform = ( ViewerTransform ) JsonHelper.getObject2( context, json, nameToClass );
		return viewerTransform;
	}

	@Override
	public JsonElement serialize( ViewerTransform viewerTransform, Type type, JsonSerializationContext context ) {
		JsonArray ja = new JsonArray();

//		if ( viewerTransform instanceof GridSourceTransformer ) {
//			ja.add( context.serialize( nameToTransformer, new TypeToken< Map< String, GridSourceTransformer > >() {}.getType() ) );
//		} else if ( sourceTransformer instanceof AffineSourceTransformer ) {
//			ja.add( context.serialize( nameToTransformer , new TypeToken< Map< String, AffineSourceTransformer > >() {}.getType() ) );
//		} else if ( sourceTransformer instanceof CropSourceTransformer ) {
//			ja.add( context.serialize( nameToTransformer , new TypeToken< Map< String, CropSourceTransformer > >() {}.getType() ) );
//		} else {
//				throw new UnsupportedOperationException( "Could not serialise SourceTransformer of type: " + sourceTransformer.getClass().toString() );
//			}
//		}

		return null;
	}
}
