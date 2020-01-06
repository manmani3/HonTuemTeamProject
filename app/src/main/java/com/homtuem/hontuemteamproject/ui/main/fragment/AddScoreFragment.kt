package com.homtuem.hontuemteamproject.ui.main.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.homtuem.hontuemteamproject.R
import com.homtuem.hontuemteamproject.ui.main.viewmodel.AddScoreViewModel

class AddScoreFragment : Fragment() {
    private lateinit var mAddScoreViewModel: AddScoreViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mAddScoreViewModel = ViewModelProviders.of(this).get(AddScoreViewModel::class.java).apply {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.add_score_fragment, container, false)
        val playerListLayout = root.findViewById<ConstraintLayout>(R.id.player_list_layout)

        var prevButtonId = 0
        mAddScoreViewModel.getPlayerList()?.let {
            for (player in it) {
                Button(context).apply {
                    text = player
                    id = View.generateViewId()
                    playerListLayout.addView(this)

                    val set = ConstraintSet()
                    set.clone(playerListLayout)

                    val constraintSide = if (prevButtonId == 0) ConstraintSet.LEFT else ConstraintSet.RIGHT
                    set.connect(id, ConstraintSet.LEFT, prevButtonId, constraintSide, 3)
                    set.connect(id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, 0)
                    set.connect(id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, 0)
                    set.constrainHeight(id, 150)
                    set.applyTo(playerListLayout)

                    prevButtonId = id
                }
            }
        }

        return root
    }

    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private const val ARG_SECTION_NUMBER = "section_number"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        @JvmStatic
        fun newInstance(): AddScoreFragment {
            return AddScoreFragment()
        }
    }
}