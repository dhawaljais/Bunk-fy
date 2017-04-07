package com.dhawal.attendancecalculator.Activities;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.dhawal.attendancecalculator.R;
import com.dhawal.attendancecalculator.Utils.LogWrapper;

import static android.support.design.R.styleable.TextInputLayout;


public class MainActivity extends AppCompatActivity {

    private EditText presentEditText, totalEditText, percentageEditText;
    private TextView presentTextView, totalTextView, percentageTextView, outputTextView;
    private ImageButton presentSubButton, presentPlusButton, totalSubButton, totalPlusButton, percentageSubButton, percentagePlusButton;
    private Button buttonCalculate;
    private final String TAG = getClass().getSimpleName();
    private TextInputLayout inputLayoutPresent, inputLayoutTotal, inputLayoutPercentage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        init();
    }

    private void init() {
//        Stepper stepperTouch = findViewById(R.id.stepperTouch);
//        stepperTouch.stepper.setMin(0);
//        stepperTouch.stepper.setMax(3)
//        stepperTouch.stepper.addStepCallback(object : OnStepCallback {
//            override fun onStep(value: Int, positive: Boolean) {
//                Toast.makeText(applicationContext, value.toString(), Toast.LENGTH_SHORT).show()
//            }
////        })
//        presentEditText = (EditText) findViewById(R.id.editText1);
//        totalEditText = (EditText) findViewById(R.id.editText2);
//        percentageEditText = (EditText) findViewById(R.id.editText3);
//        buttonCalculate = (Button) findViewById(R.id.button);
//        outputTextView = (TextView) findViewById(R.id.textOutput);
//        buttonCalculate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                evaluateResult(
//                        presentEditText.getText().toString(),
//                        totalEditText.getText().toString(),
//                        percentageEditText.getText().toString()
//                );
//            }
//        });
//        Stepper stepperTouch = (Stepper) findViewById(R.id.stepperTouch);
//        stepperTouch.setMin(0);
//        stepperTouch.setMax(999);
//        stepperTouch.addStepCallback(new OnStepCallback() {
//            @Override
//            public void onStep(int i, boolean b) {
//                Toast.makeText(MainActivity.this, i + "", Toast.LENGTH_SHORT).show();
//
//            }
//        });

        inputLayoutPresent = (TextInputLayout) findViewById(R.id.input_layout_present);
        inputLayoutTotal = (TextInputLayout) findViewById(R.id.input_layout_total);
        inputLayoutPercentage = (TextInputLayout) findViewById(R.id.input_layout_percentage);

        presentEditText = (EditText) findViewById(R.id.presentEditText1);
        totalEditText = (EditText) findViewById(R.id.presentEditText2);
        percentageEditText = (EditText) findViewById(R.id.presentEditText3);
        presentSubButton = (ImageButton) findViewById(R.id.subButton1);
        presentPlusButton = (ImageButton) findViewById(R.id.plusButton1);
        totalSubButton = (ImageButton) findViewById(R.id.subButton2);
        totalPlusButton = (ImageButton) findViewById(R.id.plusButton2);
        percentageSubButton = (ImageButton) findViewById(R.id.subButton3);
        percentagePlusButton = (ImageButton) findViewById(R.id.plusButton3);
        buttonCalculate = (Button) findViewById(R.id.outputButton);
        outputTextView = (TextView) findViewById(R.id.textOutput);

//        presentEditText.setText("0");
//        totalEditText.setText("0");
//        percentageEditText.setText("0");

        presentSubButton.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {

                                                    try {

                                                        if (!TextUtils.isEmpty(presentEditText.getText())) {

                                                            int i = Integer.parseInt(presentEditText.getText().toString());
                                                            i--;
                                                            if (i < 0) {
                                                                presentEditText.setText(0 + "");
                                                            } else
                                                                presentEditText.setText(i + "");
                                                        } else {
                                                            presentEditText.setText(0 + "");
                                                        }
                                                    } catch (Exception e) {
                                                        e.printStackTrace();
                                                    }
                                                }
                                            }
        );
        presentPlusButton.setOnClickListener(new View.OnClickListener() {
                                                 @Override
                                                 public void onClick(View v) {
                                                     try {
                                                         if (!TextUtils.isEmpty(presentEditText.getText())) {

                                                             int i = Integer.parseInt(presentEditText.getText().toString());
                                                             i++;
                                                             presentEditText.setText(i + "");
                                                         } else {
                                                             presentEditText.setText(0 + "");
                                                         }
                                                     } catch (Exception e) {
                                                         e.printStackTrace();

                                                     }
                                                 }
                                             }
        );
        totalSubButton.setOnClickListener(new View.OnClickListener() {
                                              @Override
                                              public void onClick(View v) {

                                                  try {

                                                      if (!TextUtils.isEmpty(totalEditText.getText())) {

                                                          int i = Integer.parseInt(totalEditText.getText().toString());
                                                          i--;

                                                          if (i < 0) {
                                                              totalEditText.setText(0 + "");
                                                          } else
                                                              totalEditText.setText(i + "");
                                                      } else {
                                                          totalEditText.setText(0 + "");
                                                      }
                                                  } catch (Exception e) {
                                                      e.printStackTrace();
                                                  }
                                              }
                                          }
        );
        totalPlusButton.setOnClickListener(new View.OnClickListener() {
                                               @Override
                                               public void onClick(View v) {
                                                   try {
                                                       if (!TextUtils.isEmpty(totalEditText.getText())) {

                                                           int i = Integer.parseInt(totalEditText.getText().toString());
                                                           i++;
                                                           totalEditText.setText(i + "");
                                                       } else {
                                                           totalEditText.setText(0 + "");
                                                       }
                                                   } catch (Exception e) {
                                                       e.printStackTrace();

                                                   }
                                               }
                                           }
        );
        percentageSubButton.setOnClickListener(new View.OnClickListener() {
                                                   @Override
                                                   public void onClick(View v) {

                                                       try {

                                                           if (!TextUtils.isEmpty(percentageEditText.getText())) {

                                                               float i = Float.parseFloat(percentageEditText.getText().toString());
                                                               i = i - 5;

                                                               if (i < 0) {
                                                                   percentageEditText.setText(0 + "");
                                                               } else
                                                                   percentageEditText.setText(i + "");
                                                           } else {
                                                               percentageEditText.setText(0 + "");
                                                           }
                                                       } catch (Exception e) {
                                                           e.printStackTrace();
                                                       }
                                                   }
                                               }
        );
        percentagePlusButton.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View v) {
                                                        try {
                                                            if (!TextUtils.isEmpty(percentageEditText.getText())) {
                                                                float i = Float.parseFloat(percentageEditText.getText().toString());
                                                                i = i + 5;
                                                                if (i > 100) {
                                                                    percentageEditText.setText(100 + "");
                                                                } else
                                                                    percentageEditText.setText(i + "");
                                                            } else {
                                                                percentageEditText.setText(0 + "");
                                                            }
                                                        } catch (Exception e) {
                                                            e.printStackTrace();

                                                        }
                                                    }
                                                }
        );

        presentEditText.addTextChangedListener(new MyTextWatcher(inputLayoutPresent));
        totalEditText.addTextChangedListener(new MyTextWatcher(inputLayoutTotal));
        percentageEditText.addTextChangedListener(new MyTextWatcher(inputLayoutPercentage));

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitForm();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private boolean evaluateResult(String s1, String s2, String s3) {
        try {
            int present = Integer.parseInt(s1);
            int total = Integer.parseInt(s2);
            float percentage = Float.parseFloat(s3);

            float currentPercentage = calculatePercentage(present, total);
            int updatedTotal = total;
            int updatedPresent = present;
            int counter = 0;

            if (currentPercentage < percentage) {

                LogWrapper.d(getApplicationContext(), TAG, "percentage is less than desire percentage");
//                while (currentPercentage <= percentage) {
//                    updatedPresent++;
//                    updatedTotal++;
//                    currentPercentage = calculatePercentage(updatedPresent, updatedTotal);
//                    counter++;
//                }

                outputTextView.setText("you need to do " +
                        lessPercentage(total, present, currentPercentage, percentage)
                        + "classes");

            } else if (currentPercentage > percentage) {
                LogWrapper.d(getApplicationContext(), TAG, "percentage is more than desire percentage");
                while (currentPercentage >= percentage) {
                    updatedTotal++;
                    currentPercentage = calculatePercentage(updatedPresent, updatedTotal);
                    counter++;
                }
                counter--;
                outputTextView.setText("you can bunk " + counter + "classes" + "\n" + "if you miss " + (counter + 1) + "you need" +
                        predict(present, total, counter, percentage));
            } else {
                outputTextView.setText("you cant do anything" + predict(present, total, counter, percentage));
                LogWrapper.d(getApplicationContext(), TAG, "percentage is equal to desire percentage");
            }
        } catch (Exception e) {
            LogWrapper.printStackTrace(getApplicationContext(), e);
        }
        return false;
    }

    private int predict(int present, int total, int counter, float percentage) {
        int predictTotal = total + counter + 1;
        float currentPercentage = calculatePercentage(present, predictTotal);
        return lessPercentage(predictTotal, present, currentPercentage, percentage);
    }

    private float calculatePercentage(float numerator, float denominator) {
        return ((float) numerator * 100 / denominator);
    }

    private int lessPercentage(int total, int present, float currentPercentage, float percentage) {

        int updatedTotal = total;
        int updatedPresent = present;
        int counter = 0;

        while (currentPercentage < percentage) {
            updatedPresent++;
            updatedTotal++;
            currentPercentage = calculatePercentage(updatedPresent, updatedTotal);
            counter++;
        }
        return counter;
    }


    private void submitForm() {
        if (!validatePresent()) {
            return;
        }

        if (!validateTotal()) {
            return;
        }

        if (!validatePercentage()) {
            return;
        }

        Toast.makeText(getApplicationContext(), "Thank You!", Toast.LENGTH_SHORT).show();
        evaluateResult(
                presentEditText.getText().toString(),
                totalEditText.getText().toString(),
                percentageEditText.getText().toString()
        );

    }

    private boolean validatePresent() {
        if (presentEditText.getText().toString().trim().isEmpty()) {
            inputLayoutPresent.setError(getString(R.string.err_msg_name));
            requestFocus(presentEditText);
            return false;
        } else {
            inputLayoutPresent.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateTotal() {

        if (totalEditText.getText().toString().trim().isEmpty()) {
            inputLayoutTotal.setError(getString(R.string.err_msg_email));
            requestFocus(totalEditText);
            return false;
        } else {
            inputLayoutTotal.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validatePercentage() {
        if (percentageEditText.getText().toString().trim().isEmpty()) {
            inputLayoutPercentage.setError(getString(R.string.err_msg_password));
            requestFocus(percentageEditText);
            return false;
        } else {
            inputLayoutPercentage.setErrorEnabled(false);
        }

        return true;
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    private class MyTextWatcher implements TextWatcher {

        private View view;

        private MyTextWatcher(View view) {
            this.view = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void afterTextChanged(Editable editable) {
            switch (view.getId()) {
                case R.id.presentEditText1:
                    validatePresent();
                    break;
                case R.id.presentEditText2:
                    validateTotal();
                    break;
                case R.id.presentEditText3:
                    validatePercentage();
                    break;
            }
        }
    }
}

