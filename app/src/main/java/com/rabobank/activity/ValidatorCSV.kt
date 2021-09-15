package com.rabobank.activity

import com.rabobank.models.Records

object ValidatorCSV {

    fun validateInput(firstname: String, surname: String,issuecount: Int,dateofbirth: String) :Boolean
    {
        return !(firstname.isEmpty() || surname.isEmpty() || issuecount<0 || dateofbirth.isEmpty())
    }

    fun DuplicateRecordsFound(R1: Records, R2: Records) :Boolean
    {
        return R1==R2
    }
}