package com.example.homeworklistoffilms

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class OpisanieFilmaFragment: Fragment() {

    companion object {
        private val KEY_TEXT = "special_text"

        fun newInstance(text: String): OpisanieFilmaFragment {
            val fragment = OpisanieFilmaFragment()
            val args: Bundle = Bundle()
            args.putString(KEY_TEXT, text)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.opisanie_filma, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.getString(KEY_TEXT)
    }
}