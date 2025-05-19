package com.swasi.sideeffect


/**
 * produceState: convert non-Compose state into Compose state
 */
/*@Composable
fun ProduceStateExample(
    url: String,
    imageRepository: ImageRepository = ImageRepository()
): State<Result<Image>> {
 */


// Creates a State<T> with Result.Loading as initial value
// If either `url` or `imageRepository` changes, the running producer
// will cancel and will be re-launched with the new inputs.


/*
    return produceState<Result<Image>>(initialValue = Result.Loading, url, imageRepository) {
        // In a coroutine, can make suspend calls
        val image = imageRepository.load(url)

        // Update State with either an Error or Success result.
        // This will trigger a recomposition where this State is read
        value = if (image == null) {
            Result.Error
        } else {
            Result.Success(image)
        }
    }
}*/
