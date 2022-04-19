package com.sachy.androidstructure

object AppStates {
    /**Login Screen*/
    const val LOGIN_ERROR = "LOGIN_ERROR"
    const val LOGIN_SUCCESS = "LOGIN_SUCCESS"

    /**Landing screen*/
    const val SAMPLE_ID_SUCCESS = "SAMPLE_ID_SUCCESS"
    const val SAMPLE_ID_ERROR = "SAMPLE_ID_ERROR"

    /**Assay screen*/
    const val ASSAY_SUCCESS = "ASSAY_SUCCESS"
    const val ASSAY_ERROR = "ASSAY_ERROR"

    const val SCAN_DB_SUCCESS = "SCAN_DB_SUCCESS"
    const val SCAN_DB_FAILURE = "SCAN_DB_FAILURE"

    const val SAVE_STACK_DB_SUCCESS ="SAVE_DB_SUCCESS"
    const val SAVE_STACK_DB_FAILURE ="SAVE_DB_FAILURE"

    /**Home Screen*/
    const val USER_LOADING = "USER_LOADING"
    const val USER_SUCCESS = "USER_SUCCESS"
    const val USER_ERROR = "USER_ERROR"

    /**History Screen*/
    const val SCAN_FLOW="SCAN_FLOW"
    const val STACK_FLOW="STACK_FLOW"
    const val CONTAINER_FLOW="CONTAINER_FLOW"

    const val SCAN_INSPECTION_SUCCESS = "SCAN_INSPECTION_SUCCESS"
    const val SCAN_INSPECTION_FAILURE = "SCAN_INSPECTION_FAILURE"

    const val STACK_INSPECTION_SUCCESS="STACK_INSPECTION_SUCCESS"
    const val STACK_INSPECTION_ERROR="STACK_INSPECTION_ERROR"

    const val CONTAINER_SUCCESS="CONTAINER_SUCCESS"
    const val CONTAINER_FAILURE="CONTAINER_FAILURE"

    const val SCAN_ITEM_CLICK="SCAN_ITEM_CLICK"
    const val STACK_ITEM_CLICK="STACK_ITEM_CLICK"
    const val CONTAINER_ITEM_CLICK="CONTAINER_ITEM_CLICK"


}