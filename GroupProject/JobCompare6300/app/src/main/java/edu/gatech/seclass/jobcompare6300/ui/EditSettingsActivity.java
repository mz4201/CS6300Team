package edu.gatech.seclass.jobcompare6300.ui;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import edu.gatech.seclass.jobcompare6300.R;

public class EditSettingsActivity extends AppCompatActivity {
  private SeekBar seekBarYearlySalary, seekBarYearlyBonus, seekBarTraining, seekBarLeaveTime, seekBarTelework;
  private TextView yearlySalaryValue, yearlyBonusValue, trainingValue, leaveTimeValue, teleworkValue;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_edit_settings);

    // Initialize SeekBars and TextViews
    seekBarYearlySalary = findViewById(R.id.yearlySalarySeekBar);
    seekBarYearlyBonus = findViewById(R.id.yearlyBonusSeekBar);
    seekBarTraining = findViewById(R.id.trainingSeekBar);
    seekBarLeaveTime = findViewById(R.id.leaveTimeSeekBar);
    seekBarTelework = findViewById(R.id.teleworkSeekBar);

    yearlySalaryValue = findViewById(R.id.yearlySalaryValue);
    yearlyBonusValue = findViewById(R.id.yearlyBonusValue);
    trainingValue = findViewById(R.id.trainingValue);
    leaveTimeValue = findViewById(R.id.leaveTimeValue);
    teleworkValue = findViewById(R.id.teleworkValue);

    // Setup SeekBars with their respective TextViews
    setupSeekBarListener(seekBarYearlySalary, yearlySalaryValue);
    setupSeekBarListener(seekBarYearlyBonus, yearlyBonusValue);
    setupSeekBarListener(seekBarTraining, trainingValue);
    setupSeekBarListener(seekBarLeaveTime, leaveTimeValue);
    setupSeekBarListener(seekBarTelework, teleworkValue);
  }

  private void setupSeekBarListener(SeekBar seekBar, TextView valueTextView) {
    seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
      @Override
      public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        valueTextView.setText(String.valueOf(progress));
      }

      @Override
      public void onStartTrackingTouch(SeekBar seekBar) {
        // Optionally handle event when user starts to interact with the SeekBar
      }

      @Override
      public void onStopTrackingTouch(SeekBar seekBar) {
        // Optionally handle event when user stops interacting with the SeekBar
      }
    });


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
