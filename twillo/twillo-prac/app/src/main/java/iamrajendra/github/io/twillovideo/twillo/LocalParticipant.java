package iamrajendra.github.io.twillovideo.twillo;

import android.content.Context;

import com.twilio.video.CameraCapturer;
import com.twilio.video.LocalAudioTrack;
import com.twilio.video.LocalVideoTrack;

public class LocalParticipant {
    private static LocalParticipant localParticipant;
    private  LocalAudioTrack localAudioTrack;
      LocalVideoTrack localVideoTrack;
    private  CameraCapturer cameraCapturer;
    private  Context mContext;

    public synchronized static LocalParticipant getInstance(Context context) {

        if (localParticipant==null){
            localParticipant =  new LocalParticipant(context);
        }
        return localParticipant;


    }

    public LocalParticipant(Context context) {
        mContext = context;
    }

    public void createVideoTrack(){

         localAudioTrack = LocalAudioTrack.create(mContext, true);

         cameraCapturer = new CameraCapturer(mContext,
                CameraCapturer.CameraSource.FRONT_CAMERA);

         localVideoTrack = LocalVideoTrack.create(mContext, true, cameraCapturer);



    }

    public LocalVideoTrack getLocalVideoTrack() {
        return localVideoTrack;
    }

    public void  enableAudio(){
        localAudioTrack.enable(true);
    }

    public void  disableAudio(){
        localAudioTrack.enable(false);
    }

    public void  enableVideo(){
        localVideoTrack.enable(true);
    }

    public void  disableVideo(){
        localVideoTrack.enable(false);
    }

    public void swtichCamera(){
        cameraCapturer.switchCamera();
    }

}
