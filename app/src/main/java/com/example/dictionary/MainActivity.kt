package com.example.dictionary

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.example.dictionary.databinding.ActivityMainBinding
import com.example.dictionary.feature_dictionary.domain.model.WordInfo
import com.example.dictionary.feature_dictionary.presentation.WordInfoAdapter
import com.example.dictionary.feature_dictionary.presentation.WordInfoViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: WordInfoViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setUpViewModel()
        setContentView(binding.root)
    }

    private fun setUpViewModel(){
        with(viewModel){
            MainScope().launch {
                this@with.eventFlow.collectLatest { event ->
                    when(event){
                        is WordInfoViewModel.UIEvent.ShowSnackbar ->{
                            Snackbar.make(binding.root, event.message, Snackbar.LENGTH_SHORT).show()
                        }
                    }
                }
            }
            binding.btSubmit.setOnClickListener {
                this.onSearch(binding.inputText.text.toString())
            }

            this.state.observe(this@MainActivity){
                setUpWords(it.wordInfoItems)
            }
        }

    }
    private fun setUpWords(list: List<WordInfo>){
        binding.rvWordInfo.adapter = WordInfoAdapter(binding.root, list)
    }

}