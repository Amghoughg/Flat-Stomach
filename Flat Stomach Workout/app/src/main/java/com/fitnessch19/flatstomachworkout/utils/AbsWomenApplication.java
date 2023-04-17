package com.fitnessch19.flatstomachworkout.utils;


import android.app.Application;
import android.os.Build.VERSION;
import android.speech.tts.TextToSpeech;

import com.fitnessch19.flatstomachworkout.R;

import java.util.Locale;

public class AbsWomenApplication extends Application {
    public static AbsWomenApplication absWomenApplication;
    public TextToSpeech textToSpeech;

    public static AbsWomenApplication getInstance() {
        return absWomenApplication;
    }

    public  void a() {
        if (this.textToSpeech == null) {
            this.textToSpeech = new TextToSpeech(getInstance(), new com.fitnessch19.flatstomachworkout.b.b(this));
        }
    }

    public  void a(int i) {
        if (i == 0) {
            this.textToSpeech.setLanguage(Locale.US);
        }
    }

    public void addEarCorn() {
        try {
            if (this.textToSpeech != null) {
                this.textToSpeech.addEarcon("tick", "com.fitnessch19.flatstomachworkout", R.raw.clocktick_trim);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Boolean isSpeaking() {
        return Boolean.valueOf(this.textToSpeech.isSpeaking());
    }

    public void onCreate() {
        super.onCreate();
        absWomenApplication = this;
        new Thread(new com.fitnessch19.flatstomachworkout.b.a(this)).start();
    }

    public void playEarCorn() {
        try {
            if (this.textToSpeech != null) {
                String str = "tick";
                if (VERSION.SDK_INT >= 21) {
                    this.textToSpeech.playEarcon(str, 0, null, "com.outthinking.abs");
                } else {
                    this.textToSpeech.playEarcon(str, 0, null);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void shutdown() {
        try {
            if (this.textToSpeech != null) {
                this.textToSpeech.shutdown();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void speak(String str) {
        try {
            if (this.textToSpeech != null) {
                this.textToSpeech.setSpeechRate(1.0f);
                this.textToSpeech.speak(str, 1, null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        try {
            if (this.textToSpeech != null) {
                this.textToSpeech.stop();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
