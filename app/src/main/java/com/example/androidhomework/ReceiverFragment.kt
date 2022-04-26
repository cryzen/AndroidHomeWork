package com.example.androidhomework

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class ReceiverFragment : Fragment() {

    private lateinit var viewModel: ReceiverViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_receiver, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val receiverMessage = view.findViewById<TextView>(R.id.receiver_message)

        viewModel = ViewModelProvider(this).get(ReceiverViewModel::class.java)

        viewModel.messageLiveData.observe(viewLifecycleOwner) { message ->
            receiverMessage.text = message
        }

        if (savedInstanceState == null) {
            val textMessage = arguments?.getString(MESSAGE_KEY)
            viewModel.setMessage(textMessage.toString())

            view.findViewById<Button>(R.id.read_button).setOnClickListener {
                viewModel.setMessage(getString(R.string.read_messages))
            }
        }
    }

    companion object {
        private const val MESSAGE_KEY = "MESSAGE_KEY"

        fun newInstance(textMessage: String): Fragment =
            ReceiverFragment().apply {
                val bundle = Bundle()
                bundle.putString(MESSAGE_KEY, textMessage)
                arguments = bundle
            }
    }
}