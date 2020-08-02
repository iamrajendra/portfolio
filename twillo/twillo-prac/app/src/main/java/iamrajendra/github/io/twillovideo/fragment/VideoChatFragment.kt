package iamrajendra.github.io.twillovideo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.twilio.video.VideoView
import iamrajendra.github.io.twillovideo.R
import iamrajendra.github.io.twillovideo.base.BaseFragment
import iamrajendra.github.io.twillovideo.twillo.LocalParticipant

class VideoChatFragment :BaseFragment(){
    private var  localVideoView:VideoView?=null
    private  var  localParticipant: LocalParticipant?=null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        return inflater.inflate(R.layout.video_fragment,container,false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var  roomName: String? = arguments?.getString("room_name")
        localParticipant =
            LocalParticipant.getInstance(context)
        localParticipant?.createVideoTrack()
        val videoView: VideoView = view.findViewById(R.id.localVideoView)
        localParticipant?.getLocalVideoTrack()?.addRenderer(videoView)


    }
}