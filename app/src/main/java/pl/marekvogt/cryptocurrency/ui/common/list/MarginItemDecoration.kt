package pl.marekvogt.cryptocurrency.ui.common.list

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class MarginItemDecoration(
    private val margin: Int,
    private val orientation: Orientation
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        with(outRect) {

            if (parent.getChildAdapterPosition(view) == 0) {
                when (orientation) {
                    Orientation.VERTICAL -> top = margin
                    Orientation.HORIZONTAL -> left = margin
                }
            }

            when (orientation) {
                Orientation.VERTICAL -> left = margin
                Orientation.HORIZONTAL -> top = margin
            }

            right = margin
            bottom = margin
        }
    }
}

enum class Orientation {
    VERTICAL, HORIZONTAL
}