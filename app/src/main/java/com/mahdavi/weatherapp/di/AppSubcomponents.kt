package com.mahdavi.weatherapp.di

import com.mahdavi.weatherapp.ui.auth.AuthComponent
import com.mahdavi.weatherapp.ui.dashboard.DashboardComponent
import com.mahdavi.weatherapp.ui.details.DetailsComponent
import com.mahdavi.weatherapp.ui.onboarding.OnBoardingComponent
import com.mahdavi.weatherapp.ui.splash.SplashComponent
import dagger.Module

@Module(
    subcomponents = [
        AuthComponent::class,
        OnBoardingComponent::class,
        SplashComponent::class,
        DashboardComponent::class,
        DetailsComponent::class
    ]
)
class AppSubcomponents