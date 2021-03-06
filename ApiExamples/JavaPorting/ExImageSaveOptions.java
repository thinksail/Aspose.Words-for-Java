// Copyright (c) 2001-2020 Aspose Pty Ltd. All Rights Reserved.
//
// This file is part of Aspose.Words. The source code in this file
// is only intended as a supplement to the documentation, and is provided
// "as is", without warranty of any kind, either expressed or implied.
//////////////////////////////////////////////////////////////////////////

package ApiExamples;

// ********* THIS FILE IS AUTO PORTED *********

import org.testng.annotations.Test;
import com.aspose.words.Document;
import com.aspose.words.ImageSaveOptions;
import com.aspose.words.SaveFormat;
import com.aspose.words.ImageColorMode;
import com.aspose.words.ImagePixelFormat;
import com.aspose.ms.NUnit.Framework.msAssert;
import org.testng.Assert;
import com.aspose.words.TiffCompression;
import com.aspose.words.ImageBinarizationMethod;


@Test
class ExImageSaveOptions !Test class should be public in Java to run, please fix .Net source!  extends ApiExampleBase
{
    @Test
    public void useGdiEmfRenderer() throws Exception
    {
        //ExStart
        //ExFor:ImageSaveOptions.UseGdiEmfRenderer
        //ExSummary:Shows how to save metafiles directly without using GDI+ to EMF.
        Document doc = new Document(getMyDir() + "SaveOptions.MyriadPro.docx");

        ImageSaveOptions saveOptions = new ImageSaveOptions(SaveFormat.EMF);
        {
            saveOptions.setUseGdiEmfRenderer(false);
        }

        doc.save(getArtifactsDir() + "SaveOptions.UseGdiEmfRenderer.docx", saveOptions);
        //ExEnd
    }

    @Test
    public void saveIntoGif() throws Exception
    {
        //ExStart
        //ExFor:ImageSaveOptions.PageIndex
        //ExSummary:Shows how to save specific document page as image file.
        Document doc = new Document(getMyDir() + "SaveOptions.MyriadPro.docx");

        ImageSaveOptions saveOptions = new ImageSaveOptions(SaveFormat.GIF);
        {
            saveOptions.setPageIndex(0); // Define which page will save
        }

        doc.save(getArtifactsDir() + "SaveOptions.MyraidPro.gif", saveOptions);
        //ExEnd
    }


    @Test (groups = "SkipMono")
    public void converImageColorsToBlackAndWhite() throws Exception
    {
        //ExStart
        //ExFor:ImageColorMode
        //ExFor:ImagePixelFormat
        //ExFor:ImageSaveOptions.Clone
        //ExFor:ImageSaveOptions.ImageColorMode
        //ExFor:ImageSaveOptions.PixelFormat
        //ExSummary:Show how to convert document images to black and white with 1 bit per pixel
        Document doc = new Document(getMyDir() + "ImageSaveOptions.BlackAndWhite.docx");

        ImageSaveOptions imageSaveOptions = new ImageSaveOptions(SaveFormat.PNG);
        imageSaveOptions.setImageColorMode(ImageColorMode.BLACK_AND_WHITE);
        imageSaveOptions.setPixelFormat(ImagePixelFormat.FORMAT_1_BPP_INDEXED);

        // ImageSaveOptions instances can be cloned
        msAssert.areNotEqual(imageSaveOptions, imageSaveOptions.deepClone());  

        doc.save(getArtifactsDir() + "ImageSaveOptions.BlackAndWhite.png", imageSaveOptions);
        //ExEnd
    }

    @Test
    public void thresholdForFloydSteinbergDithering() throws Exception
    {
        //ExStart
        //ExFor:ImageBinarizationMethod
        //ExFor:ImageSaveOptions.ThresholdForFloydSteinbergDithering
        //ExFor:ImageSaveOptions.TiffBinarizationMethod
        //ExSummary: Shows how to control the threshold for TIFF binarization in the Floyd-Steinberg method
        Document doc = new Document (getMyDir() + "ImagesSaveOptions.ThresholdForFloydSteinbergDithering.docx");

        ImageSaveOptions options = new ImageSaveOptions(SaveFormat.TIFF);
        {
            options.setTiffCompression(TiffCompression.CCITT_3);
            options.setImageColorMode(ImageColorMode.GRAYSCALE);
            options.setTiffBinarizationMethod(ImageBinarizationMethod.FLOYD_STEINBERG_DITHERING);
            // The default value of this property is 128. The higher value, the darker image
            options.setThresholdForFloydSteinbergDithering((byte) 254);
        }

        doc.save(getArtifactsDir() + "ImagesSaveOptions.ThresholdForFloydSteinbergDithering.tiff", options);
        //ExEnd
    }

    @Test
    public void editImage() throws Exception
    {
        //ExStart
        //ExFor:ImageSaveOptions.HorizontalResolution
        //ExFor:ImageSaveOptions.ImageBrightness
        //ExFor:ImageSaveOptions.ImageContrast
        //ExFor:ImageSaveOptions.SaveFormat
        //ExFor:ImageSaveOptions.Scale
        //ExFor:ImageSaveOptions.VerticalResolution
        //ExSummary:
        Document doc = new Document(getMyDir() + "Rendering.doc");

        // When saving the document as an image, we can use an ImageSaveOptions object to edit various aspects of it
        ImageSaveOptions options = new ImageSaveOptions(SaveFormat.PNG);
        {
            options.setImageBrightness(0.3f);     // 0 - 1 scale, default at 0.5
            options.setImageContrast(0.7f);       // 0 - 1 scale, default at 0.5
            options.setHorizontalResolution(72f); // Default at 96.0 meaning 96dpi, image dimensions will be affected if we change resolution
            options.setVerticalResolution(72f);   // Default at 96.0 meaning 96dpi
            options.setScale(96f / 72f);           // Default at 1.0 for normal scale, can be used to negate resolution impact in image size
        }

        doc.save(getArtifactsDir() + "ImagesSaveOptions.EditImage.png", options);
        //ExEnd
    }
}
