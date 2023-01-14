import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class OneDayForcast(
    val dailyForecasts: List<DailyForecast>,
    val headline: Headline
)

@JsonClass(generateAdapter = true)
data class DailyForecast(
    val airAndPollen: List<AirAndPollen>,
    @Json(name = "Date") val date: String,
    val day: Day,
    @Json(name = "EpochDate") val epochDate: Int,
    @Json(name = "HoursOfSun") val hoursOfSun: Double,
    @Json(name = "Link") val link: String,
    @Json(name = "MobileLink") val mobileLink: String,
    val moon: Moon,
    val night: Night,
    val realFeelTemperature: RealFeelTemperature,
    @Json(name = "Sources") val sources: List<String>,
    val sun: Sun
)

@JsonClass(generateAdapter = true)
data class Headline(
    @Json(name = "Category") val category: String,
    @Json(name = "EffectiveDate") val effectiveDate: String,
    @Json(name = "EffectiveEpochDate") val effectiveEpochDate: Int,
    @Json(name = "EndDate") val endDate: String,
    @Json(name = "EndEpochDate") val endEpochDate: Int,
    @Json(name = "Link") val link: String,
    @Json(name = "MobileLink") val mobileLink: String,
    @Json(name = "Severity") val severity: Int,
    @Json(name = "Text") val text: String
)

@JsonClass(generateAdapter = true)
data class AirAndPollen(
    @Json(name = "Category") val category: String,
    @Json(name = "CategoryValue") val categoryValue: Int,
    @Json(name = "Name") val name: String,
    @Json(name = "Type") val type: String,
    @Json(name = "Value") val value: Int
)

@JsonClass(generateAdapter = true)
data class Day(
    @Json(name = "CloudCover") val cloudCover: Int,
    @Json(name = "HasPrecipitation") val hasPrecipitation: Boolean,
    @Json(name = "HoursOfIce") val hoursOfIce: Int,
    @Json(name = "HoursOfPrecipitation") val hoursOfPrecipitation: Int,
    @Json(name = "HoursOfRain") val hoursOfRain: Int,
    @Json(name = "HoursOfSnow") val hoursOfSnow: Int,
    val ice: Ice,
    @Json(name = "IceProbability") val iceProbability: Int,
    @Json(name = "Icon") val icon: Int,
    @Json(name = "IconPhrase") val iconPhrase: String,
    @Json(name = "LongPhrase") val longPhrase: String,
    @Json(name = "PrecipitationProbability") val precipitationProbability: Int,
    val rain: Rain,
    @Json(name = "RainProbability") val rainProbability: Int,
    @Json(name = "ShortPhrase") val shortPhrase: String,
    val snow: Snow,
    @Json(name = "SnowProbability") val snowProbability: Int,
    @Json(name = "ThunderstormProbability") val thunderstormProbability: Int,
    val wind: Wind
)

@JsonClass(generateAdapter = true)
data class Moon(
    @Json(name = "Age") val age: Int,
    @Json(name = "EpochRise") val epochRise: Int,
    @Json(name = "EpochSet") val epochSet: Int,
    @Json(name = "Phase") val phase: String,
    @Json(name = "Rise") val rise: String,
    @Json(name = "Set") val set: String
)

@JsonClass(generateAdapter = true)
data class Night(
    @Json(name = "HoursOfIce")  val hoursOfIce: Int,
    @Json(name = "HoursOfPrecipitation")  val hoursOfPrecipitation: Int,
    @Json(name = "HoursOfRain")  val hoursOfRain: Int,
    @Json(name = "HoursOfSnow")  val hoursOfSnow: Int,
    val ice: Ice,
    @Json(name = "Icon")  val icon: Int,
    @Json(name = "IconPhrase")  val iconPhrase: String,
    @Json(name = "LongPhrase")  val longPhrase: String,
    @Json(name = "PrecipitationProbability")  val precipitationProbability: Int,
    val rain: Rain,
    @Json(name = "RainProbability")  val rainProbability: Int,
    @Json(name = "ShortPhrase")  val shortPhrase: String,
    val snow: Snow,
    @Json(name = "SnowProbability")  val snowProbability: Int
)

@JsonClass(generateAdapter = true)
data class RealFeelTemperature(
    @Json(name = "Maximum") val maximum: Maximum,
    @Json(name = "Minimum") val minimum: Minimum
)


@JsonClass(generateAdapter = true)
data class Sun(
    @Json(name = "EpochRise")  val epochRise: Int,
    @Json(name = "EpochSet")  val epochSet: Int,
    @Json(name = "Rise")  val rise: String,
    @Json(name = "Set")  val set: String
)


@JsonClass(generateAdapter = true)
data class Ice(
    @Json(name = "Unit") val unit: String,
    @Json(name = "UnitType") val unitType: Int,
    @Json(name = "Value") val value: Int
)

@JsonClass(generateAdapter = true)
data class Rain(
    @Json(name = "Unit") val unit: String,
    @Json(name = "UnitType") val unitType: Int,
    @Json(name = "Value") val value: Int
)

@JsonClass(generateAdapter = true)
data class Snow(
    @Json(name = "Unit") val unit: String,
    @Json(name = "UnitType") val unitType: Int,
    @Json(name = "Value") val value: Int
)


@JsonClass(generateAdapter = true)
data class Wind(
    @Json(name = "Direction") val direction: Direction,
    @Json(name = "Speed") val speed: Speed
)


@JsonClass(generateAdapter = true)
data class Direction(
    @Json(name = "Degrees") val degrees: Int,
    @Json(name = "English") val english: String,
    @Json(name = "Localized") val localized: String
)

@JsonClass(generateAdapter = true)
data class Speed(
    @Json(name = "Unit") val unit: String,
    @Json(name = "UnitType") val unitType: Int,
    @Json(name = "Value") val value: Double
)


@JsonClass(generateAdapter = true)
data class Maximum(
    @Json(name = "Phrase") val phrase: String,
    @Json(name = "Unit") val unit: String,
    @Json(name = "UnitType") val unitType: Int,
    @Json(name = "Value") val value: Double
)

@JsonClass(generateAdapter = true)
data class Minimum(
    @Json(name = "Phrase") val phrase: String,
    @Json(name = "Unit") val unit: String,
    @Json(name = "UnitType") val unitType: Int,
    @Json(name = "Value") val value: Double
)

