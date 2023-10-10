package com.example.calc

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.calc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    private val imageList = arrayListOf<Int>(
        R.drawable.ac,
        R.drawable.del,
        R.drawable.foiz,
        R.drawable.bolish,
        R.drawable.seven,
        R.drawable.eight,
        R.drawable.nine,
        R.drawable.multiplacitation,
        R.drawable.fore,
        R.drawable.five,
        R.drawable.six,
        R.drawable.minus,
        R.drawable.one,
        R.drawable.two,
        R.drawable.three,
        R.drawable.plus,
        R.drawable.sero,
        R.drawable.vergun,
        R.drawable.common,
        R.drawable.teng,


        )


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)


        val adapter = CustumAdapter(context = this, imageList)




        binding.gridView.adapter = adapter


        binding.gridView.setOnItemClickListener { _, _, position, _ ->
            when (position) {
                0 -> {
                    binding.textView.text = null
                }

                1 -> {
                    val tw = binding.textView.text

                    val mys = tw.dropLast(1)

                    binding.textView.text = mys

                }

                2 -> {

                }

                3 -> {
                    var tw = binding.textView.text.toString()
                    if (tw.contains("/")) {
                    } else {
                        binding.textView.text = tw + "/"
                    }

                }

                4 -> {
                    var tw = binding.textView.text.toString()

                    binding.textView.text = tw + "7"
                }

                5 -> {
                    var tw = binding.textView.text.toString()

                    binding.textView.text = tw + "8"
                }

                6 -> {
                    var tw = binding.textView.text.toString()

                    binding.textView.text = tw + "9"
                }

                7 -> {
                    var tw = binding.textView.text.toString()
                    if (tw.contains("*")) {
                    } else {
                        binding.textView.text = tw + "*"
                    }
                }

                8 -> {
                    var tw = binding.textView.text.toString()

                    binding.textView.text = tw + "4"
                }

                9 -> {
                    var tw = binding.textView.text.toString()

                    binding.textView.text = tw + "5"
                }

                10 -> {
                    var tw = binding.textView.text.toString()

                    binding.textView.text = tw + "6"
                }

                11 -> {
                    var tw = binding.textView.text.toString()
                    if (tw.contains("-")) {
                    } else {
                        binding.textView.text = tw + "-"
                    }
                }

                12 -> {
                    var tw = binding.textView.text.toString()

                    binding.textView.text = tw + "1"
                }

                13 -> {
                    var tw = binding.textView.text.toString()

                    binding.textView.text = tw + "2"
                }

                14 -> {
                    var tw = binding.textView.text.toString()

                    binding.textView.text = tw + "3"
                }

                15 -> {
                    var tw = binding.textView.text.toString()
                    if (tw.contains("+")) {
                    } else {
                        binding.textView.text = tw + "+"
                    }
                }

                16 -> {
                    var tw = binding.textView.text.toString()

                    binding.textView.text = tw + "0"
                }

                17 -> {
                    val tw = binding.textView.text.toString()
                    if (tw.contains(".")) {
                    } else {
                        binding.textView.text = tw + "."
                    }
                }

                19 -> {
                    val tw = binding.textView.text.toString()

                    if (tw.contains("+")) {
                        if (tw.contains("=") && tw.contains("-")) {
                        } else {
                            val numbers = extractNumbers(tw)

                            val sum = numbers[0] + numbers[1]
                            binding.textView.text = tw + "=$sum"
                        }
                    }
                    if (tw.contains("-")) {
                        if (tw.contains("=")) {
                        } else {
                            val numbers = extractNumbers(tw)

                            val sum = numbers[0] - numbers[1]
                            binding.textView.text = tw + "=$sum"
                        }
                    }
                    if (tw.contains("*")) {
                        if (tw.contains("=")) {
                        } else {
                            val numbers = extractNumbers(tw)

                            val sum = numbers[0] * numbers[1]
                            binding.textView.text = tw + "=$sum"
                        }
                    }
                    if (tw.contains("/")) {
                        if (tw.contains("=")) {
                        } else {
                            val numbers = extractNumbers(tw)

                            val sum = numbers[0] / numbers[1]
                            binding.textView.text = tw + "=$sum"
                        }
                    }
                }
            }
        }
        var textview = binding.textView
    }

    private fun extractNumbers(text: String): List<Int> {
        val numbers = mutableListOf<Int>()
        var numberString = ""

        for (character in text) {
            if (character.isDigit()) {
                numberString += character
            } else if (numberString.isNotEmpty()) {
                numbers.add(numberString.toInt())
                numberString = ""
            }
        }

        if (numberString.isNotEmpty()) {
            numbers.add(numberString.toInt())
        }

        return numbers
    }
}