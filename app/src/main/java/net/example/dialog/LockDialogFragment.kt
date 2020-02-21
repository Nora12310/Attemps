package net.example.dialog

import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.DialogFragment
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.dialog_lock_view.*
import net.example.R
import java.util.concurrent.TimeUnit

class LockDialogFragment : androidx.fragment.app.DialogFragment() {
    private var inAnimation: Animation? = null
    private var outAnimation: Animation? = null
    private lateinit var countdown: CountDownTimer

    override fun onStart() {
        super.onStart()
        dialog?.window?.apply {
            isCancelable = false
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_TITLE, R.style.CustomDialogTheme)
        val time = arguments?.getInt(ARG_SECONDS, 60) ?: 60
        countdown = object : CountDownTimer(time * 1000L, 1000) { // adjust the milli seconds here
            override fun onTick(millisUntilFinished: Long) {
                if (tv_content == null) {
                    return
                }
                val seconds = TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished)
                val text = tv_content.context.getText(R.string.msg_lock_confirmed_otp).toString().format(seconds)
                tv_content.text = Html.fromHtml(text)
            }

            override fun onFinish() {
                dismiss()
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.dialog_lock_view, container, false)
        inAnimation = AnimationUtils.loadAnimation(context, R.anim.slide_up)
        outAnimation = AnimationUtils.loadAnimation(context, R.anim.slide_down)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        view_content.startAnimation(inAnimation)
    }

    override fun onResume() {
        super.onResume()
        countdown.start()
    }

    override fun onPause() {
        super.onPause()
        countdown.cancel()
    }

    companion object {
        private const val ARG_SECONDS = "argument-seconds-lock-dialog"
        fun newInstance(seconds: Int): LockDialogFragment {
            val fragment = LockDialogFragment()
            val arguments = Bundle()
            arguments.putInt(ARG_SECONDS, seconds)
            fragment.arguments = arguments
            return fragment
        }
    }
}