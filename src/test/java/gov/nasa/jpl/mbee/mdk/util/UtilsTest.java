
package gov.nasa.jpl.mbee.mdk.util;

import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.core.Project;
import com.nomagic.magicdraw.tests.MagicDrawTestRunner;
import com.nomagic.magicdraw.uml.BaseElement;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Property;
import com.nomagic.uml2.ext.magicdraw.mdprofiles.Stereotype;

import gov.nasa.jpl.mbee.mdk.api.MagicDrawHelper;
import gov.nasa.jpl.mbee.mdk.http.ServerException;
import gov.nasa.jpl.mbee.mdk.options.MDKEnvironmentOptionsGroup;

import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author ablack
 * @JIRA MAGICDRAW-263
 *
 */
@RunWith(MagicDrawTestRunner.class)
public class UtilsTest {

    private static Project project;

    public UtilsTest() {
    }

    @BeforeClass
    public static void setupProject() throws IOException, ServerException, URISyntaxException {
        ClassLoader classLoader = UtilsTest.class.getClassLoader();
        File testProjectFile = File.createTempFile("prj", ".mdzip");
        IOUtils.copy(classLoader.getResourceAsStream("CSyncTest.mdzip"), new FileOutputStream(testProjectFile));

        MDKEnvironmentOptionsGroup.getInstance().setDefaultValues();
        MDKEnvironmentOptionsGroup.getInstance().setLogJson(true);
        MagicDrawHelper.openProject(testProjectFile);
        project = Application.getInstance().getProject();
    }

    /********************************************** Direct Stereotype Utils **********************************************/





    @AfterClass
    public static void closeProject() throws IOException {
        MagicDrawHelper.closeProject();
    }

}
