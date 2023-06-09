package com.example.jetpackcomposeapp.ui.theme

import android.content.Context
import android.graphics.Color
import android.util.Log
import android.widget.TextView
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import com.example.jetpackcomposeapp.R
import org.osmdroid.config.Configuration
import org.osmdroid.events.MapEventsReceiver
import org.osmdroid.util.BoundingBox
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.MapEventsOverlay
import org.osmdroid.views.overlay.Marker
import org.osmdroid.views.overlay.Polyline
import org.osmdroid.views.overlay.infowindow.InfoWindow


@Composable
fun OsmdroidMap() {
    val context = LocalContext.current
    // Initialize osmdroid configuration
    Configuration.getInstance().load(context,context.getSharedPreferences("osmdroid", Context.MODE_PRIVATE))
    // Create and configure the MapView
    val mapView = rememberMapView()

    Log.d("MyTag","Reload")


    // Return the MapView as a Composable
    AndroidView(
        factory = { mapView },
        modifier = Modifier.fillMaxSize()
    ) { view ->
        view.apply {
            initMap(this)

            val geoPoint = GeoPoint(28.6798,77.0927)
//
//            addMarker(context, view,geoPoint)


            val eventsOverlay = mapEventsOverlay(
                context, view,
                onTap = { lat, lng ->
                    val geoPoint2 = GeoPoint(lat,lng)
                    addMarker(context, view,geoPoint2)
                }
            )

            val startPoint = geoPoint // Example start latitude and longitude
            val endPoint = GeoPoint(37.7876, -122.3966) // Example end latitude and longitude

            // Create a polyline between the start and end points
            val polyline = createPolyline(view, startPoint, endPoint)
            view.overlays.add(polyline)

            view.overlays.add(0, eventsOverlay)

            view.controller.setCenter(geoPoint)


        }
    }
}

private fun initMap(mapView : MapView){
    mapView.apply {
        isHorizontalMapRepetitionEnabled = false
        isVerticalMapRepetitionEnabled = false
        setMultiTouchControls(true)
        val tileSystem = MapView.getTileSystem()
        setScrollableAreaLimitDouble(BoundingBox(
            tileSystem.maxLatitude, tileSystem.maxLongitude, // top-left
            tileSystem.minLatitude, tileSystem.minLongitude  // bottom-right
        ))
        minZoomLevel = 4.0
        mapView.controller.setZoom(6.0)
    }
}


@Composable
private fun rememberMapView(): MapView {
    val context = LocalContext.current
    val mapView = remember{
        MapView(context)
    }
    // Cleanup the MapView when the composable is disposed
    DisposableEffect(Unit) {
        onDispose {
            mapView.onDetach()
        }
    }
    return mapView
}


private fun mapEventsOverlay(context : Context, view : MapView, onTap : (lat : Double, lng : Double)->Unit ) : MapEventsOverlay{
    return MapEventsOverlay(object : MapEventsReceiver {
        override fun singleTapConfirmedHelper(p: GeoPoint?): Boolean {
            // Handle the map click event
            if (p != null) {
                val latitude = p.latitude
                val longitude = p.longitude

                onTap(latitude,longitude)



                view.invalidate() // Refresh the map view
            }
            return true
        }

        override fun longPressHelper(p: GeoPoint?): Boolean {
            // Handle long press event if needed
            return false
        }
    })
}


private fun addMarker(context : Context,view : MapView, geoPoint: GeoPoint){
    val marker = Marker(view)
    marker.position = geoPoint
    marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
    /// Custom Info Window
    marker.infoWindow = CustomInfoWindow(view, "Hello", "World")

//    marker.title = "Hello"
//    marker.snippet = "<b>World</b><br>Test"

    view.overlays.add(marker)
}


class CustomInfoWindow(
    mapView: MapView,
    private val title: String,
    private val snippet: String
) : InfoWindow(R.layout.custom_info_window, mapView) {

    override fun onOpen(item: Any?) {

        val view = mView
        if (view != null) {
//            val infoWindowLayout = view.findViewById<LinearLayout>(R.id.infoWindowLayout)

            // Set the desired background color
//            infoWindowLayout.setBackgroundColor(Color.BLUE)

            val titleTextView = view.findViewById<TextView>(R.id.tvInfoTitle)
            val snippetTextView = view.findViewById<TextView>(R.id.tvSnippet)

            titleTextView.text = title
            snippetTextView.text = snippet

            // Adjust the text color and other styling as desired
            titleTextView.setTextColor(Color.WHITE)
            snippetTextView.setTextColor(Color.WHITE)
        }
    }

    override fun onClose() {
        super.close()
    }
}

// Draw path bw two point
private fun createPolyline(mapView: MapView, startPoint: GeoPoint, endPoint: GeoPoint): Polyline {
    val polyline = Polyline(mapView)
    polyline.color = 0xFF0000FF.toInt() // Set color to blue
    polyline.addPoint(startPoint)
    polyline.addPoint(endPoint)
    return polyline
}


