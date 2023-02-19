import csstype.ClassName
import kotlinx.browser.window
import react.FC
import react.Props
import react.dom.html.ReactHTML.p
import react.key
import react.useState

external interface VideoListProps: Props {
    var videos: List<Video>
    var selectedVideo: Video?
    var onVideoSelected: (Video) -> Unit
}

val VideoList = FC<VideoListProps> {props ->
    for (video in props.videos) {
        p {
            className = ClassName("cursor-pointer")
            key = video.id.toString()
            if(video == props.selectedVideo) {
                +"▶ "
            }
            +"${video.speaker}: ${video.title}"
            onClick = {
                props.onVideoSelected(video)
            }
        }
    }
}