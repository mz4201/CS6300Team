package edu.gatech.seclass.jobcompare6300.ui;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import edu.gatech.seclass.jobcompare6300.R;

public class EditSettingsActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle bundle) {
    super.onCreate(bundle);
    setContentView(R.layout.activity_edit_settings);

    var saveButton = findViewById(R.id.editSettingsSaveButton);
    saveButton.setOnClickListener(view -> save());

    var cancelButton = findViewById(R.id.editSettingsCancelButton);
    cancelButton.setOnClickListener(view -> cancel());
  }

  private void save() {
    finish();
  }

  private void cancel() {
    finish();
  }
}
