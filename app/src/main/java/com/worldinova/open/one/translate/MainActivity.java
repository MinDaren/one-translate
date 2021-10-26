package com.worldinova.open.one.translate;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import com.google.mlkit.common.model.DownloadConditions;
import com.google.mlkit.common.model.RemoteModelManager;
import com.google.mlkit.nl.languageid.LanguageIdentification;
import com.google.mlkit.nl.languageid.LanguageIdentifier;
import com.google.mlkit.nl.translate.TranslateLanguage;
import com.google.mlkit.nl.translate.TranslateRemoteModel;
import com.google.mlkit.nl.translate.Translation;
import com.google.mlkit.nl.translate.Translator;
import com.google.mlkit.nl.translate.TranslatorOptions;

public class MainActivity extends AppCompatActivity {

    MaterialButton btn, copy;
    TextInputLayout edit_text;
    TextView result, status, target_lan_tv;
    String source_text;
    LinearLayout load;
    ImageView donate,help,delete_iv;
    Animation fade_in,fade_out;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn);
        edit_text = findViewById(R.id.edit_text);
        result = findViewById(R.id.result);
        status = findViewById(R.id.status);
        target_lan_tv = findViewById(R.id.target_lan_tv);
        load = findViewById(R.id.load);
        copy = findViewById(R.id.copy);

        donate = findViewById(R.id.donate);
        help = findViewById(R.id.help);
        delete_iv = findViewById(R.id.delete_iv);

        fade_in = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_in_bottom);
        fade_out = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_out_bottom);

        help.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://worldinova.code.blog/help/translate"));
            startActivity(intent);
        });

        donate.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://worldinova.code.blog/doanate/translate"));
            startActivity(intent);
        });

        target_lan_tv.setOnClickListener(v -> {
            PopupMenu popupMenu = new PopupMenu(MainActivity.this, btn);
            popupMenu.getMenuInflater().inflate(R.menu.lan, popupMenu.getMenu());
            popupMenu.show();
            popupMenu.setOnMenuItemClickListener(item -> {
                target_lan_tv.setText(item.getTitle());
                return true;
            });
        });

        copy.setOnClickListener(v -> {

            String copy_string = result.getText().toString();

            ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData clipData = ClipData.newPlainText("Result", copy_string);
            clipboardManager.setPrimaryClip(clipData);

            Toast.makeText(MainActivity.this, "Successfully Copied To Clipboard", Toast.LENGTH_SHORT).show();
        });

        btn.setOnClickListener(v -> {

            source_text = edit_text.getEditText().getText().toString();

            LanguageIdentifier languageIdentifier = LanguageIdentification.getClient();
            languageIdentifier.identifyLanguage(source_text).addOnSuccessListener(languageCode -> {

                if (languageCode.equals("und")) {
                    Toast.makeText(getApplicationContext(), "Fail to identify language", Toast.LENGTH_SHORT).show();
                } else {

                    String target_tv_string = target_lan_tv.getText().toString();

                    if (target_tv_string.equals("Afrikaans")) {
                        translate("af", languageCode);
                    } else if (target_tv_string.equals("Arabic")) {
                        translate("ar", languageCode);
                    } else if (target_tv_string.equals("Belarusian")) {
                        translate("be", languageCode);
                    } else if (target_tv_string.equals("Bulgarian")) {
                        translate("bg", languageCode);
                    } else if (target_tv_string.equals("Bengali")) {
                        translate("bn", languageCode);
                    } else if (target_tv_string.equals("Catalan")) {
                        translate("ca", languageCode);
                    } else if (target_tv_string.equals("Czech")) {
                        translate("cs", languageCode);
                    } else if (target_tv_string.equals("Welsh")) {
                        translate("cy", languageCode);
                    } else if (target_tv_string.equals("Danish")) {
                        translate("da", languageCode);
                    } else if (target_tv_string.equals("German")) {
                        translate("de", languageCode);
                    } else if (target_tv_string.equals("Greek")) {
                        translate("el", languageCode);
                    } else if (target_tv_string.equals("English")) {
                        translate("en", languageCode);
                    } else if (target_tv_string.equals("Esperanto")) {
                        translate("eo", languageCode);
                    } else if (target_tv_string.equals("Spanish")) {
                        translate("es", languageCode);
                    } else if (target_tv_string.equals("Estonian")) {
                        translate("et", languageCode);
                    } else if (target_tv_string.equals("Persian")) {
                        translate("fa", languageCode);
                    } else if (target_tv_string.equals("Finnish")) {
                        translate("fi", languageCode);
                    } else if (target_tv_string.equals("French")) {
                        translate("fr", languageCode);
                    } else if (target_tv_string.equals("Irish")) {
                        translate("ga", languageCode);
                    } else if (target_tv_string.equals("Galician")) {
                        translate("gl", languageCode);
                    } else if (target_tv_string.equals("Gujarati")) {
                        translate("gu", languageCode);
                    } else if (target_tv_string.equals("Hebrew")) {
                        translate("he", languageCode);
                    } else if (target_tv_string.equals("Hindi")) {
                        translate("hi", languageCode);
                    } else if (target_tv_string.equals("Croatian")) {
                        translate("hr", languageCode);
                    } else if (target_tv_string.equals("Haitian")) {
                        translate("ht", languageCode);
                    } else if (target_tv_string.equals("Hungarian")) {
                        translate("hu", languageCode);
                    } else if (target_tv_string.equals("Indonesian")) {
                        translate("id", languageCode);
                    } else if (target_tv_string.equals("Icelandic")) {
                        translate("is", languageCode);
                    } else if (target_tv_string.equals("Italian")) {
                        translate("it", languageCode);
                    } else if (target_tv_string.equals("Japanese")) {
                        translate("ja", languageCode);
                    } else if (target_tv_string.equals("Georgian")) {
                        translate("ka", languageCode);
                    } else if (target_tv_string.equals("Kannada")) {
                        translate("kn", languageCode);
                    } else if (target_tv_string.equals("Korean")) {
                        translate("ko", languageCode);
                    } else if (target_tv_string.equals("Lithuanian")) {
                        translate("lt", languageCode);
                    } else if (target_tv_string.equals("Latvian")) {
                        translate("fr", languageCode);
                    } else if (target_tv_string.equals("Macedonian")) {
                        translate("mk", languageCode);
                    } else if (target_tv_string.equals("Marathi")) {
                        translate("mr", languageCode);
                    } else if (target_tv_string.equals("Malay")) {
                        translate("ms", languageCode);
                    } else if (target_tv_string.equals("Maltese")) {
                        translate("mt", languageCode);
                    } else if (target_tv_string.equals("Dutch")) {
                        translate("nl", languageCode);
                    } else if (target_tv_string.equals("Norwegian")) {
                        translate("no", languageCode);
                    } else if (target_tv_string.equals("Polish")) {
                        translate("pl", languageCode);
                    } else if (target_tv_string.equals("Portuguese")) {
                        translate("pt", languageCode);
                    } else if (target_tv_string.equals("Romanian")) {
                        translate("ro", languageCode);
                    } else if (target_tv_string.equals("Russian")) {
                        translate("ru", languageCode);
                    } else if (target_tv_string.equals("Slovak")) {
                        translate("sk", languageCode);
                    } else if (target_tv_string.equals("Slovenian")) {
                        translate("sl", languageCode);
                    } else if (target_tv_string.equals("Albanian")) {
                        translate("sq", languageCode);
                    } else if (target_tv_string.equals("Swedish")) {
                        translate("sv", languageCode);
                    } else if (target_tv_string.equals("Swahili")) {
                        translate("sw", languageCode);
                    } else if (target_tv_string.equals("Tamil")) {
                        translate("ta", languageCode);
                    } else if (target_tv_string.equals("Telugu")) {
                        translate("te", languageCode);
                    } else if (target_tv_string.equals("Thai")) {
                        translate("th", languageCode);
                    } else if (target_tv_string.equals("Tagalog")) {
                        translate("tl", languageCode);
                    } else if (target_tv_string.equals("Turkish")) {
                        translate("tr", languageCode);
                    } else if (target_tv_string.equals("Ukrainian")) {
                        translate("uk", languageCode);
                    } else if (target_tv_string.equals("Urdu")) {
                        translate("ur", languageCode);
                    } else if (target_tv_string.equals("Vietnamese")) {
                        translate("vi", languageCode);
                    } else if (target_tv_string.equals("Chinese")) {
                        translate("zh", languageCode);
                    } else {
                        Toast.makeText(getApplicationContext(), "Try another language", Toast.LENGTH_SHORT).show();
                    }

                }
            })


                    .addOnFailureListener(e -> {
                        // Model couldn’t be loaded or other internal error.
                        Toast.makeText(getApplicationContext(), "Internal error.try online", Toast.LENGTH_SHORT).show();
                    });


        });
    }

    private void translate(String target, String source) {

        load.setVisibility(View.VISIBLE);
        load.setAnimation(fade_in);

        TranslatorOptions options = new TranslatorOptions.Builder()
                .setSourceLanguage(source)
                .setTargetLanguage(target)
                .build();

        final Translator englishGermanTranslator = Translation.getClient(options);

        DownloadConditions conditions = new DownloadConditions.Builder().build();
        englishGermanTranslator.downloadModelIfNeeded(conditions).addOnSuccessListener(unused ->

                englishGermanTranslator.translate(source_text)
                        .addOnSuccessListener(s -> {
                            result.setText(s);
                            load.setVisibility(View.GONE);
                            load.setAnimation(fade_out);
                        })
                        .addOnFailureListener(e -> {
                            Toast.makeText(getApplicationContext(), "Fail to translate.try online", Toast.LENGTH_SHORT).show();
                            load.setVisibility(View.GONE);
                            load.setAnimation(fade_out);
                        }))

                .addOnFailureListener(e -> {
                    // Model couldn’t be downloaded or other internal error.
                    Toast.makeText(getApplicationContext(), "Seem to like fist time package.try online", Toast.LENGTH_SHORT).show();
                    load.setVisibility(View.GONE);
                    load.setAnimation(fade_out);
                });

    }

    private void delete(String del) {
        RemoteModelManager modelManager = RemoteModelManager.getInstance();

        // Delete the German model if it's on the device.
        TranslateRemoteModel germanModel = new TranslateRemoteModel.Builder(del).build();
        modelManager.deleteDownloadedModel(germanModel).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(@NonNull Void unused) {
                Toast.makeText(getApplicationContext(), "Successfully deleted library", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(e -> {
            // Error.
            Toast.makeText(getApplicationContext(), "Fail to deleted library", Toast.LENGTH_SHORT).show();

        });

    }
}