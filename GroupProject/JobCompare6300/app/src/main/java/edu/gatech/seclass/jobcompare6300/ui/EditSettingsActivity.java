package edu.gatech.seclass.jobcompare6300.ui;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import edu.gatech.seclass.jobcompare6300.R;

public class EditSettingsActivity extends AppCompatActivity {
  private SeekBar seekBarYearlySalary;
  private TextView labelYearlySalary;

  @Override
  protected void onCreate(Bundle bundle) {
    super.onCreate(bundle);
    setContentView(R.layout.activity_edit_settings);

    seekBarYearlySalary = findViewById(R.id.seekBarYearlySalary);
    labelYearlySalary = findViewById(R.id.labelYearlySalary);

    setupSeekBarListener(seekBarYearlySalary, labelYearlySalary);

    // Uncommented save and cancel button setup
        /*
        var saveButton = findViewById(R.id.editSettingsSaveButton);
        saveButton.setOnClickListener(view -> save());

        var cancelButton = findViewById(R.id.editSettingsCancelButton);
        cancelButton.setOnClickListener(view -> cancel());
        */
  }

  private void save() {
    finish();
  }

  private void cancel() {
    finish();
  }

  private void setupSeekBarListener(SeekBar seekBar, TextView label) {
    seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
      @Override
      public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        label.setText(String.valueOf(progress));
      }

      @Override
      public void onStartTrackingTouch(SeekBar seekBar) {
        // Not needed for implementation
      }

      @Override
      public void onStopTrackingTouch(SeekBar seekBar) {
        // Not needed for implementation
      }
    });
  }
}
