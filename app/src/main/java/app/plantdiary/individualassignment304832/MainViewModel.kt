package app.plantdiary.individualassignment304832

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.plantdiary.individualassignment304832.service.CountryService
import app.plantdiary.individualassignment304832.dto.Country
import kotlinx.coroutines.launch
import org.koin.core.component.getScopeId

class MainViewModel: ViewModel() {
    var countries = MutableLiveData<List<Country>>()
    var countryService : CountryService = CountryService()

    fun fetchCountries() {
        viewModelScope.launch {
            var innerCountry = countryService.fetchCountries()
            countries.postValue(innerCountry)
        }
    }
}