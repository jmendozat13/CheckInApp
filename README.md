# CheckInApp usin compose navigation (Kotlin + MVVM + Compose)

This project demonstrates how to use compose navigation for easy onboarding for your app

## 🚀 Features:
- Splash.
- Onboarding.
- SignUp.
- Login
- Reset Identifier
- Built with **Kotlin, MVVM architecture & Jetpack Compose**.
- Clean and maintainable code structure.

## Demo
https://github.com/user-attachments/assets/2ffaf1db-2fdc-43ca-8438-ef62e95b6051

## Navigation Graph
```kotlin
interface ScreenNavigationGraph
@Serializable object OnboardingScreenGraphScreen : ScreenNavigationGraph
@Serializable object LoginScreenGraphScreen : ScreenNavigationGraph
@Serializable object SignupScreenGraphScreen : ScreenNavigationGraph
@Serializable object HomeScreenGraphScreen :  ScreenNavigationGraph
@Serializable object LoadingScreenGraphScreen :  ScreenNavigationGraph
@Serializable object ResetIdentifierGraphScreen: ScreenNavigationGraph
```

## Navigation Wrapper
```kotlin
@Composable
fun NavigationWrapper(
    navController: NavHostController,
    startDestination: ScreenNavigationGraph
) {
    NavHost(navController = navController, startDestination = startDestination) {
        composable<OnboardingScreenGraphScreen> {
            OnboardingScreen(navigateTo = {
                navController.navigate(it) {
                    popUpTo<OnboardingScreenGraphScreen> { inclusive = true }
                }
            })
        }

        composable<LoginScreenGraphScreen> {
            LoginScreen { destination ->
                when (destination) {
                    is HomeScreenGraphScreen, SignupScreenGraphScreen -> {
                        navController.navigate(destination) {
                            popUpTo<LoginScreenGraphScreen> { inclusive = true }
                            launchSingleTop = true
                        }
                    }

                    else ->
                        navController.navigate(destination)
                }
            }
        }

        composable<SignupScreenGraphScreen> {
            SignupScreen { destination ->
                when (destination) {
                    is HomeScreenGraphScreen, LoginScreenGraphScreen -> {
                        navController.navigate(destination) {
                            popUpTo<SignupScreenGraphScreen> { inclusive = true }
                            launchSingleTop = true
                        }
                    }

                    else -> navController.navigate(destination)
                }

            }
        }
        composable<HomeScreenGraphScreen> {
            HomeScreen()
        }
        composable<LoadingScreenGraphScreen> {
            LoadingScreen()
        }
        composable<ResetIdentifierGraphScreen> {
            ResetIdentifierScreen(onBack = {
                navController.popBackStack()
            })
        }
    }
}
```
## 🔧 Tech Stack:
- **Kotlin**
- **MVVM Architecture**
- **Jetpack Compose**

## 💡 Open Question: 
Feel free to share your experience or approach! Let’s collaborate and learn together.
