package com.tranhuuphuc.kotlinkoincoroutinemvvm.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.tranhuuphuc.kotlinkoincoroutinemvvm.R
import com.tranhuuphuc.kotlinkoincoroutinemvvm.utils.dialog.BlockingProgressDialogFragment

/**
 * Created by TranHuuPhuc on 2019-07-27.
 */
abstract class BaseFragment : Fragment() {
    @LayoutRes
    abstract fun getLayoutId(): Int

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(getLayoutId(), container, false)
    }

    protected fun acknowledgeConnectionError() = Snackbar.make(requireView(), R.string.error_not_connected, Snackbar.LENGTH_SHORT).show()

    protected fun acknowledgeError(message: String) = Snackbar.make(requireView(), message, Snackbar.LENGTH_SHORT).show()

    fun showBlockingProgressDialog(message: String = getString(R.string.please_wait), tag: String = TAG_DIALOG_PROGRESS) = BlockingProgressDialogFragment.show(requireFragmentManager(), message, tag)

    fun hideProgressDialog(tag: String = TAG_DIALOG_PROGRESS) = (fragmentManager?.findFragmentByTag(tag) as? DialogFragment)?.dismiss()

    companion object {
        private const val TAG_DIALOG_PROGRESS = "progress_dialog"
    }

}