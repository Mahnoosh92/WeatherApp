package com.mahdavi.weatherapp.ui.onboarding

import com.mahdavi.weatherapp.di.ActivityScope
import dagger.Subcomponent

@ActivityScope
@Subcomponent
interface OnBoardingComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): OnBoardingComponent
    }

    fun inject(activity: OnBoardingActivity)
}