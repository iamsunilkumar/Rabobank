package com.rabobank.activity


import com.google.common.truth.Truth.assertThat
import com.rabobank.models.Records
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.util.*


@RunWith(JUnit4::class)
class ValidatorCSVTest
{
    @Test
    fun whenCsvInputIsValid()
    {
        val First_name = "Theo"
        val Sur_name = "Jansen"
        val Issue_count  = 5
        val Date_of_birth = "1978-01-02T00:00:00"
        val result = ValidatorCSV.validateInput(First_name,Sur_name,Issue_count,Date_of_birth)
        assertThat(result).isEqualTo(true)
    }

    @Test
    fun whenCsvInputIsInvalid()
    {
        val First_name = ""
        val Sur_name = "Jansen"
        val Issue_count  = 5
        val Date_of_birth = "1978-01-02T00:00:00"
        val result = ValidatorCSV.validateInput(First_name,Sur_name,Issue_count,Date_of_birth)
        assertThat(result).isEqualTo(false)
    }

    @Test
    fun getDuplicateRecords() {
        val inputList: List<Records> = Arrays.asList(
            Records("Theo","Jansen",5,"1978-01-02T00:00:00"),
            Records("Theo","Jansen",5,"1978-01-02T00:00:00")
        )
        val result = ValidatorCSV.DuplicateRecordsFound(inputList.get(0),inputList.get(1))
        assertThat(result).isEqualTo(true)
    }

    @Test
    fun getNoDuplicateRecords() {
        val inputList: List<Records> = Arrays.asList(
            Records("Theo","Jansen",5,"1978-01-02T00:00:00"),
            Records("Fiona","de Vries",7,"1950-11-12T00:00:00")
        )
        val result = ValidatorCSV.DuplicateRecordsFound(inputList.get(0),inputList.get(1))
        assertThat(result).isEqualTo(false)
    }
}