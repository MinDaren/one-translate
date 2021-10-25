package com.worldinova.open.one.translate;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import com.google.mlkit.common.model.DownloadConditions;
import com.google.mlkit.nl.languageid.LanguageIdentification;
import com.google.mlkit.nl.languageid.LanguageIdentifier;
import com.google.mlkit.nl.translate.Translation;
import com.google.mlkit.nl.translate.Translator;
import com.google.mlkit.nl.translate.TranslatorOptions;

public class MainActivity extends AppCompatActivity {

    MaterialButton btn;
    TextInputLayout edit_text;
    TextView result,status,target_lan_tv;
    String source_text;

    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn);
        edit_text = findViewById(R.id.edit_text);
        result = findViewById(R.id.result);
        status = findViewById(R.id.status);
        target_lan_tv = findViewById(R.id.target_lan_tv);

        target_lan_tv.setOnClickListener(v -> {
            PopupMenu popupMenu = new PopupMenu(MainActivity.this,btn);
            popupMenu.getMenuInflater().inflate(R.menu.lan,popupMenu.getMenu());
            popupMenu.show();
            popupMenu.setOnMenuItemClickListener(item -> {
                target_lan_tv.setText(item.getTitle());
                return true;
            });
        });

        btn.setOnClickListener(v -> {

            source_text = edit_text.getEditText().getText().toString();

            LanguageIdentifier languageIdentifier = LanguageIdentification.getClient();
            languageIdentifier.identifyLanguage(source_text).addOnSuccessListener(languageCode -> {

                                if (languageCode.equals("und")) {
                                    Toast.makeText(getApplicationContext(), "Fail to identify language", Toast.LENGTH_SHORT).show();
                                } else {

                                    String target_tv_string = target_lan_tv.getText().toString();

                                    if (target_tv_string.equals("Afrikaans")){
                                        translate("af",languageCode);
                                    }else if (target_tv_string.equals("Arabic")){
                                        translate("ar",languageCode);
                                    }else if (target_tv_string.equals("Belarusian")){
                                        translate("be",languageCode);
                                    }else if (target_tv_string.equals("Bulgarian")){
                                        translate("bg",languageCode);
                                    }else if (target_tv_string.equals("Bengali")){
                                        translate("bn",languageCode);
                                    }else if (target_tv_string.equals("Catalan")){
                                        translate("ca",languageCode);
                                    }else if (target_tv_string.equals("Czech")){
                                        translate("cs",languageCode);
                                    } else if (target_tv_string.equals("Welsh")){
                                        translate("cy",languageCode);
                                    }else if (target_tv_string.equals("Danish")){
                                        translate("da",languageCode);
                                    }else if (target_tv_string.equals("German")){
                                        translate("de",languageCode);
                                    }else if (target_tv_string.equals("Greek")){
                                        translate("el",languageCode);
                                    }else if (target_tv_string.equals("English")){
                                        translate("en",languageCode);
                                    }else if (target_tv_string.equals("Esperanto")){
                                        translate("eo",languageCode);
                                    }else if (target_tv_string.equals("Spanish")){
                                        translate("es",languageCode);
                                    }else if (target_tv_string.equals("Estonian")){
                                        translate("et",languageCode);
                                    }else if (target_tv_string.equals("Persian")){
                                        translate("fa",languageCode);
                                    }else if (target_tv_string.equals("Finnish")){
                                        translate("fi",languageCode);
                                    }else if (target_tv_string.equals("French")){
                                        translate("fr",languageCode);
                                    }


                                    else if (target_tv_string.equals("Irish")){
                                        translate("ga",languageCode);
                                    }else if (target_tv_string.equals("Galician")){
                                        translate("gl",languageCode);
                                    }else if (target_tv_string.equals("Gujarati")){
                                        translate("gu",languageCode);
                                    }else if (target_tv_string.equals("Hebrew")){
                                        translate("he",languageCode);
                                    }else if (target_tv_string.equals("Hindi")){
                                        translate("hi",languageCode);
                                    }else if (target_tv_string.equals("Croatian")){
                                        translate("hr",languageCode);
                                    } else if (target_tv_string.equals("Haitian")){
                                        translate("ht",languageCode);
                                    }else if (target_tv_string.equals("Hungarian")){
                                        translate("hu",languageCode);
                                    }else if (target_tv_string.equals("Indonesian")){
                                        translate("id",languageCode);
                                    }else if (target_tv_string.equals("Icelandic")){
                                        translate("is",languageCode);
                                    }else if (target_tv_string.equals("Italian")){
                                        translate("it",languageCode);
                                    }else if (target_tv_string.equals("Japanese")){
                                        translate("ja",languageCode);
                                    }else if (target_tv_string.equals("Georgian")){
                                        translate("ka",languageCode);
                                    }else if (target_tv_string.equals("Kannada")){
                                        translate("kn",languageCode);
                                    }else if (target_tv_string.equals("Korean")){
                                        translate("ko",languageCode);
                                    }else if (target_tv_string.equals("Lithuanian")){
                                        translate("lt",languageCode);
                                    }else if (target_tv_string.equals("Latvian")){
                                        translate("fr",languageCode);
                                    }


                                    else if (target_tv_string.equals("Macedonian")){
                                        translate("mk",languageCode);
                                    }else if (target_tv_string.equals("Marathi")){
                                        translate("mr",languageCode);
                                    }else if (target_tv_string.equals("Malay")){
                                        translate("ms",languageCode);
                                    }else if (target_tv_string.equals("Maltese")){
                                        translate("mt",languageCode);
                                    }else if (target_tv_string.equals("Dutch")){
                                        translate("nl",languageCode);
                                    }else if (target_tv_string.equals("Norwegian")){
                                        translate("no",languageCode);
                                    } else if (target_tv_string.equals("Polish")){
                                        translate("pl",languageCode);
                                    }else if (target_tv_string.equals("Portuguese")){
                                        translate("pt",languageCode);
                                    }else if (target_tv_string.equals("Romanian")){
                                        translate("ro",languageCode);
                                    }else if (target_tv_string.equals("Russian")){
                                        translate("ru",languageCode);
                                    }else if (target_tv_string.equals("Slovak")){
                                        translate("sk",languageCode);
                                    }else if (target_tv_string.equals("Slovenian")){
                                        translate("sl",languageCode);
                                    }else if (target_tv_string.equals("Albanian")){
                                        translate("sq",languageCode);
                                    }else if (target_tv_string.equals("Swedish")){
                                        translate("sv",languageCode);
                                    }else if (target_tv_string.equals("Swahili")){
                                        translate("sw",languageCode);
                                    }else if (target_tv_string.equals("Tamil")){
                                        translate("ta",languageCode);
                                    }else if (target_tv_string.equals("Telugu")){
                                        translate("te",languageCode);
                                    } else if (target_tv_string.equals("Thai")){
                                        translate("th",languageCode);
                                    }else if (target_tv_string.equals("Tagalog")){
                                        translate("tl",languageCode);
                                    }else if (target_tv_string.equals("Turkish")){
                                        translate("tr",languageCode);
                                    }else if (target_tv_string.equals("Ukrainian")){
                                        translate("uk",languageCode);
                                    }else if (target_tv_string.equals("Urdu")){
                                        translate("ur",languageCode);
                                    }else if (target_tv_string.equals("Vietnamese")){
                                        translate("vi",languageCode);
                                    }else if (target_tv_string.equals("Chinese")){
                                        translate("zh",languageCode);
                                    }else {
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

    private void translate(String target,String source) {

        load();
        dialog.show();

        TranslatorOptions options =
                new TranslatorOptions.Builder()
                        .setSourceLanguage(source)
                        .setTargetLanguage(target)
                        .build();

        final Translator englishGermanTranslator = Translation.getClient(options);

        DownloadConditions conditions = new DownloadConditions.Builder().build();
        englishGermanTranslator.downloadModelIfNeeded(conditions).addOnSuccessListener(unused ->

                englishGermanTranslator.translate(source_text)
                        .addOnSuccessListener(s -> {
                            result.setText(s);
                            dialog.hide();
                        })
                        .addOnFailureListener(e -> {
                            Toast.makeText(getApplicationContext(), "Fail to translate.try online", Toast.LENGTH_SHORT).show();
                            dialog.hide();
                        }))

                .addOnFailureListener(e -> {
                    // Model couldn’t be downloaded or other internal error.
                    Toast.makeText(getApplicationContext(), "Seem to like fist time package.try online", Toast.LENGTH_SHORT).show();
                    dialog.hide();
                });

    }

    private void load() {

        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.layout_bottom_sheet);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.CENTER);
        dialog.setCancelable(false);


    }
}