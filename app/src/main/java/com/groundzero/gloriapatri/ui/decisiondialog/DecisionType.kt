package com.groundzero.gloriapatri.ui.decisiondialog

enum class DecisionType(internal val code: Int) {
    PRAYER_ADD_BOOKMARK(0);

    companion object {
        fun valueOf(value: Int): DecisionType? =
            values().find { it.code == value } ?:
            throw DecisionDialogException("Code does not exist")
    }
}