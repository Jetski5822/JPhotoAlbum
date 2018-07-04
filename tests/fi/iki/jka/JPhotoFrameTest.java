package fi.iki.jka;


import org.junit.Test;

import java.awt.event.ActionEvent;

import static org.junit.Assert.assertTrue;


public class JPhotoFrameTest {
    @Test
    public void showSlideshowWhenPhotoIsAvailable() throws Exception {
        JPhotoCollection collection = new JPhotoCollection();
        final boolean[] hasSlideshowBeenShown = new boolean[]{false};
        collection.add(0, new JPhoto());
        JPhotoFrame frame = new JPhotoFrame(null, collection) {
            @Override
            public void showSlideshow() {
                hasSlideshowBeenShown[0] = true;
            }
        };

        frame.actionPerformed(new ActionEvent("", 0, JPhotoMenu.A_SLIDESHOW));

        assertTrue(hasSlideshowBeenShown[0]);
    }

    @Test
    public void displayErrorWhenInvalidPhoto() throws Exception {
        JPhotoCollection collection = new JPhotoCollection() {
            @Override
            public boolean load(String filename) {
                return true;
            }
        };
        final boolean[] errorMessageShown = new boolean[]{false};

        JPhotoFrame frame = new JPhotoFrame("ddd", collection) {
            @Override
            public void showSlideShowErrorMessage() {
                errorMessageShown[0] = true;
            }
        };

        frame.actionPerformed(new ActionEvent("", 0, JPhotoMenu.A_SLIDESHOW));

        assertTrue(errorMessageShown[0]);
    }

    }
