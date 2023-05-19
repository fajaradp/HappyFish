package com.fajaradp.happyfish.model

import android.os.Parcelable
import com.google.firebase.Timestamp
import kotlinx.parcelize.Parcelize


@Parcelize
data class DataReport(

    val waktu: Timestamp?=null,
    val keterangan: String?=null,
): Parcelable