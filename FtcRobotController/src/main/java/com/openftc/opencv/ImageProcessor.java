package com.openftc.opencv;


import org.opencv.core.Mat;

/**
 * Interface for image processors - outputs modified OpenCV matrix data
 * Benjamin Ward, FTC 4592
 * Date Created: 10/24/17
 */
public interface ImageProcessor<ResultType> {
    ImageProcessorResult<ResultType> process(long startTime, Mat rgbaFrame, boolean saveImages);

    /**
     * Stores image processing data
     * Benjamin Ward, FTC 4592
     * Date Created: 10/24/17
     */
    class ImageProcessorResult<ResultType> {
        private final long startTime, endTime;
        private final ResultType result;
        private final Mat frame;

        ImageProcessorResult(long startTime, Mat frame, ResultType result) {
            this.startTime = startTime;
            this.result = result;
            this.frame = frame;
            this.endTime = System.currentTimeMillis();
        }

        public long getStartTime() {
            return startTime;
        }

        public long getEndTime() {
            return endTime;
        }

        public long getElapsedTime() {
            return endTime - startTime;
        }

        public boolean isResultNull() {
            return result == null;
        }

        public ResultType getResult() {
            return result;
        }

        public Mat getFrame() {
            return frame;
        }

        @Override
        public String toString() {
            if (isResultNull()) {
                return "null";
            } else {
                return result.toString();
            }
        }
    }

}
