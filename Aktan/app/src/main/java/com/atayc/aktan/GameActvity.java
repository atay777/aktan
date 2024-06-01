package com.atayc.aktan;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class GameActvity extends AppCompatActivity {

    private EditText inputName;
    private boolean areButtonsVisible = false;

    private Button submitButton;
    private Button aBtn, bBtn;
    private String playerName = "";
    TextView speech;
    ImageView aktan;
    MediaPlayer at;
    MediaPlayer background;
    private int textIndex = 0;
    private String[] texts = {
            "Сенин атың ким?",
            "Таанышканыма кубанычтамын.",
            "Сен бул жерде жаңы болушуң керек.",
            "Биздин мекенибиз жөнүндө бир аз айтып берүү мен үчүн чоң сыймык.",
            "Кыргызстан - асман тиреген тоолордун жана кең, дөңсөөлүү жайыттардын өлкөсү.",
            "Биздин үй деп атаган аймак Ысык-Көл өрөөнү деп аталат, дүйнөдөгү экинчи чоң тоо көлү болгон кооз Ысык-Көлдүн үйү.",
            "Ысык-Көл кыргыз эли үчүн ыйык жер. Анын аты биздин тилде Жылуу көл дегенди билдирет, анткени суу эң катуу кышта да толук муздабайт.",
            "Биздин эл кылымдар бою ушул тоолордо көчмөн малчылар болуп жашап келген, жайкы жана кышкы жайыттардын ортосунда көчүп жүрөбүз.",
            "Биз кой, эчки жана жылкы оторлорубузга кам көрөбүз, алардан жүн, эт жана сүт алабыз - биздин салттуу жашоо образдарыбыздын негизги азыктары.",
            "Малдарыбыздан тышкары, Ысык-Көл аймагы өзүнүн мол жаратылыш байлыктары менен белгилүү.",
            "Биз ошондой эле түшүмдүү өрөөндөрдө арпа, буудай жана жашылчаларды өстүрөбүз.",
            "Манас кыргыз элинин эң белгилүү жана урматтуу эпикалык каарманы болуп саналат.",
            "Манас эпосунун башкы каарманы. Манас кыргыз урууларынын башын бириктирип, эл-жеринин биримдигин жана эркиндигин коргоо үчүн күрөшкөн.",
            "Ал ар түрдүү жоо менен согушуп, кыргыз элинин даңкын арттырган баатыр катары белгилүү.",
            "Манас эпосу кыргыз улуттук аң-сезиминин жана маданиятынын маанилүү бөлүгү болуп саналат"

    };
    private MediaPlayer mediaPlayer;
    private int[] audioResIds = {
            0,
            R.raw.nicetomeetu,
            R.raw.yourenew,
            R.raw.honor,
            R.raw.kyrgyzstan,
            R.raw.kyrgyzstan2,
            R.raw.kyrgyzstan3,
            R.raw.kyrgyzstan4,
            R.raw.kyrgyzstan5,
            R.raw.kyrgyzstan6,
            R.raw.kyrgyzstan7,
            R.raw.manas,
            R.raw.manas2,
            R.raw.manas3,
            R.raw.manas4


};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_actvity);

        Window window = this.getWindow();
        window.setStatusBarColor(this.getResources().getColor(R.color.black));


        speech = findViewById(R.id.speechTV);
        inputName = findViewById(R.id.inputName);
        submitButton = findViewById(R.id.submitButton);
        aBtn = findViewById(R.id.aBtn);
        bBtn = findViewById(R.id.bBtn);
        aktan = findViewById(R.id.charAI);

        aBtn.setVisibility(View.GONE);
        bBtn.setVisibility(View.GONE);


        View rootView = findViewById(android.R.id.content);
        rootView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    if (textIndex < texts.length) {
                        if (texts[textIndex].equals("Сенин атың ким?")) {
                            at = MediaPlayer.create(GameActvity.this, R.raw.name);
                            if (at != null) {
                                at.start();
                            }
                            showInputField();
                        } else {
                            updateStory();
                        }
                    }
                }
                if (event.getAction() == MotionEvent.ACTION_DOWN && !areButtonsVisible) {
                    if (textIndex < texts.length) {
                        switch (textIndex) {
                            case 0:
                                aktan.setImageResource(R.drawable.aktan);
                                aBtn.setVisibility(View.GONE);
                                bBtn.setVisibility(View.GONE);
                                areButtonsVisible = false;
                                break;
                            case 1:
                                aktan.setImageResource(R.drawable.aktan);
                                aBtn.setVisibility(View.GONE);
                                bBtn.setVisibility(View.GONE);
                                areButtonsVisible = false;
                                break;
                            case 2:
                                aktan.setImageResource(R.drawable.aktan);
                                aBtn.setVisibility(View.GONE);
                                bBtn.setVisibility(View.GONE);
                                areButtonsVisible = false;
                                break;
                            case 3:
                                aktan.setImageResource(R.drawable.aktan);
                                aBtn.setVisibility(View.VISIBLE);
                                bBtn.setVisibility(View.VISIBLE);
                                areButtonsVisible = true;
                                break;
                            case 4:
                                aktan.setImageResource(R.drawable.aktan);
                                aBtn.setVisibility(View.GONE);
                                bBtn.setVisibility(View.GONE);
                                areButtonsVisible = false;
                                break;
                        }
                    }
                }
                return true;
            }
        });
        aBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aBtn.setVisibility(View.GONE);
                bBtn.setVisibility(View.GONE);
                goToNextCase();
            }
        });
        bBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aBtn.setVisibility(View.GONE);
                bBtn.setVisibility(View.GONE);
                goToNextCase();
            }
        });
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerName = inputName.getText().toString();
                if (!playerName.isEmpty()) {
                    inputName.setVisibility(View.GONE);
                    submitButton.setVisibility(View.GONE);

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            textIndex++;
                            updateStory();
                        }
                    }, 0);
                } else {
                    Toast.makeText(GameActvity.this, "Сенин атың ким?", Toast.LENGTH_SHORT).show();
                }
            }
        });
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerName = inputName.getText().toString();
                if (!playerName.isEmpty()) {
                    inputName.setVisibility(View.GONE);
                    submitButton.setVisibility(View.GONE);

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            textIndex++;
                            updateStory();
                        }
                    }, 0);
                } else {
                    Toast.makeText(GameActvity.this, "Сенин атың ким?", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void updateStory() {
        if (textIndex < texts.length) {
            speech.setText(texts[textIndex]);
            Log.d("PlayActivity", "Displaying text: " + texts[textIndex]);

            switch (textIndex) {
                case 0:
                    aktan.setImageResource(R.drawable.aktan);
                    aBtn.setVisibility(View.GONE);
                    bBtn.setVisibility(View.GONE);
                    break;
                case 1:
                    aktan.setImageResource(R.drawable.aktan);
                    aBtn.setVisibility(View.GONE);
                    bBtn.setVisibility(View.GONE);
                    break;
                case 2:
                    aktan.setImageResource(R.drawable.aktan);
                    aBtn.setVisibility(View.GONE);
                    bBtn.setVisibility(View.GONE);
                    break;
                case 3:
                    aktan.setImageResource(R.drawable.aktan);
                    aBtn.setVisibility(View.VISIBLE);
                    bBtn.setVisibility(View.VISIBLE);
                    aBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            goToNextCase();
                        }
                    });
                    bBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            goToNextCase();
                        }
                    });
                    break;
                case 4:
                    aktan.setImageResource(R.drawable.aktan);
                    aBtn.setVisibility(View.GONE);
                    bBtn.setVisibility(View.GONE);
                    break;
                case 5:
                    aktan.setImageResource(R.drawable.aktan);
                    break;
                case 6:
                    aktan.setImageResource(R.drawable.aktan);
                    break;
                case 7:
                    aktan.setImageResource(R.drawable.aktan);
                    break;
                case 8:
                    aktan.setImageResource(R.drawable.aktan);
                    break;
                case 9:
                    aktan.setImageResource(R.drawable.aktan);
                case 10:
                    aktan.setImageResource(R.drawable.aktan);
                    break;
                case 11:
                    aktan.setImageResource(R.drawable.akylai);
                    break;
                case 12:
                    aktan.setImageResource(R.drawable.akylai);
                    break;
                case 13:
                    aktan.setImageResource(R.drawable.akylai);
                    break;

            }

            if (mediaPlayer != null) {
                mediaPlayer.release();
            }

            if (audioResIds[textIndex] != 0) {
                mediaPlayer = MediaPlayer.create(GameActvity.this, audioResIds[textIndex]);
                if (mediaPlayer != null) {
                    mediaPlayer.start();
                    Log.d("PlayActivity", "Playing audio: " + audioResIds[textIndex]);
                } else {
                    Log.e("PlayActivity", "Failed to create MediaPlayer for audio: " + audioResIds[textIndex]);
                }
            }

            textIndex++;
        } else {
            speech.setText("The End");
            Log.d("PlayActivity", "Displaying text: The End");
        }
    }
    private void showInputField() {
        speech.setText(texts[textIndex]);
        inputName.setVisibility(View.VISIBLE);
        submitButton.setVisibility(View.VISIBLE);
    }
    private void goToNextCase() {
        textIndex = 4;
    }
    @Override
    protected void onPause() {
        super.onPause();
        stopAllMusic();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopAllMusic();
    }

    private void stopAllMusic() {
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
            }
            mediaPlayer.release();
            mediaPlayer = null;
        }
        if (background != null) {
            if (background.isPlaying()) {
                background.stop();
            }
            background.release();
            background = null;
        }
    }
}
