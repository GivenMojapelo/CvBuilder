package com.givenchdy.cvbuilder.cvbuilder.Controllers;

import android.os.Environment;
import android.util.Log;

import com.givenchdy.cvbuilder.cvbuilder.Models.CvDataModel;
import com.givenchdy.cvbuilder.cvbuilder.Models.ReferencesModel;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPRow;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by Given Mojapelo on 3/26/2017.
 */


public class PdfController {


    private static Font titleFont = new Font(Font.FontFamily.TIMES_ROMAN, 24, Font.BOLD);
    private static Font sectionTitleFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.UNDERLINE);
    private static String TAG = "PdfController";

    Document document;
    String fileName;

    public static void createCvFolder(String folderPath)
    {

        try {
            File folder = new File(Environment.getExternalStorageDirectory() +
                    File.separator + folderPath);
            boolean success = true;
            if (!folder.exists()) {
                success = folder.mkdirs();
            }
            if (success) {
                // Do something on success
            } else {
                // Do something else on failure
            }
        }
        catch (Exception ex)
        {
            Log.e(TAG, "Error encountered while creating a directory");
            ex.printStackTrace();
        }
        Log.d(TAG, "END: createRoastProfilesFolder");
    }




    public PdfController(String fileName)
    {

        try
        {
            createCvFolder("cv");
            fileName = Environment.getExternalStorageDirectory() + "/cv/" + fileName + ".pdf";
            this.fileName = fileName;
            document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(fileName));

        }
        catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }


    public void buildPdf()
    {
        Log.d(TAG, "buildPdf:start");
        try {
            document.open();
            addTitle(document);
            addSectionTitle(document, "Personal Details");
            addPersonalSectionContent(document);

            if(CvDataModel.getInstance().getSecondarySchoolModels()[0] != null) {
                addSectionTitle(document, "Educational Details - Secondary Level");
                addEducationalSecondarySectionContent(document);
                addLineSpace(document);
            }

            if(CvDataModel.getInstance().getTertiarySchoolModels()[0] != null && !CvDataModel.getInstance().getTertiarySchoolModels()[0].getSchoolName().equals("")) {
                addSectionTitle(document, "Educational Details - Tertiary Level");
                for (int i = 0; i < CvDataModel.getInstance().getTertiarySchoolModels().length; i++) {
                    if (CvDataModel.getInstance().getTertiarySchoolModels()[i] != null) {
                        addEducationalTertiarySectionContent(document, i);
                    }
                }
            }
            if(CvDataModel.getInstance().getWorkEntries()[0] != null && !CvDataModel.getInstance().getWorkEntries()[0].getCompanyName().equals(""))
            {
                addSectionTitle(document, "Work History");
                for(int i = 0; i < CvDataModel.getInstance().getWorkEntries().length; i++)
                {
                    addWorkHistorySectionContent(document, i);
                }
            }

            addSectionTitle(document, "References");
            addReferenceSectionContent(document);

            document.close();

        } catch (DocumentException e) {
            e.printStackTrace();
        }

    }

    private void addLineSpace(Document document) throws DocumentException  {
        Paragraph graph = new Paragraph();
        graph.add(new Paragraph("\r\n"));
        document.add(graph);
    }

    private void addTitle(Document document) throws DocumentException {

        Paragraph graph = new Paragraph();

        graph.setAlignment(Element.ALIGN_CENTER);

        graph.add(new Paragraph(""));
        Paragraph m = new Paragraph("Curriculum Vitae of \r ".toUpperCase() + CvDataModel.getInstance().getLastName().toUpperCase()
                      + " " + CvDataModel.getInstance().getFirstName().toUpperCase() + " "  +
                      CvDataModel.getInstance().getMiddleName().toUpperCase(), titleFont);



        m.setAlignment(Element.ALIGN_CENTER);
        graph.add(m);
        graph.add(new Paragraph("\n\r"));
        document.add(graph);
    }

    private void addSectionTitle(Document document, String title) throws DocumentException {
        Paragraph graph = new Paragraph();

        graph.setAlignment(Element.ALIGN_LEFT);

        graph.add(new Paragraph(""));
        graph.add(new Paragraph(title, sectionTitleFont));
        graph.add(new Paragraph("\r"));

        document.add(graph);
    }


    private void addWorkHistorySectionContent(Document document, int index) throws  DocumentException
    {

        PdfPTable sectionTable = new PdfPTable(2);
        sectionTable.getDefaultCell().setBorder(Rectangle.NO_BORDER);


        //Work company
        PdfPCell cell1 = new PdfPCell(new Paragraph("Company Name"));
        PdfPCell cell2 = new PdfPCell(new Paragraph(": " + CvDataModel.getInstance().getWorkEntries()[index].getCompanyName()));
        cell1.setBorder(Rectangle.NO_BORDER);
        cell2.setBorder(Rectangle.NO_BORDER);
        cell1.setPaddingBottom(10);
        cell2.setPaddingBottom(10);
        PdfPCell CompanyNamecells[] = new PdfPCell[]{cell1, cell2};
        PdfPRow CompanyNameRow = new PdfPRow(CompanyNamecells);
        sectionTable.getRows().add(CompanyNameRow);


        //company position
        PdfPCell cell3 = new PdfPCell(new Paragraph("Role"));
        PdfPCell cell4 = new PdfPCell(new Paragraph(": " + CvDataModel.getInstance().getWorkEntries()[index].getPositionName()));
        cell3.setBorder(Rectangle.NO_BORDER);
        cell4.setBorder(Rectangle.NO_BORDER);
        cell3.setPaddingBottom(10);
        cell4.setPaddingBottom(10);
        PdfPCell Rolecells[] = new PdfPCell[]{cell3, cell4};
        PdfPRow RoleRow = new PdfPRow(Rolecells);
        sectionTable.getRows().add(RoleRow);


        //company duration
        PdfPCell cell5 = new PdfPCell(new Paragraph("Duration"));
        PdfPCell cell6 = new PdfPCell(new Paragraph(": " + CvDataModel.getInstance().getWorkEntries()[index].getDuration()));
        cell5.setBorder(Rectangle.NO_BORDER);
        cell6.setBorder(Rectangle.NO_BORDER);
        cell5.setPaddingBottom(10);
        cell6.setPaddingBottom(10);
        PdfPCell Durationcells[] = new PdfPCell[]{cell5, cell6};
        PdfPRow DurationRow = new PdfPRow(Durationcells);
        sectionTable.getRows().add(DurationRow);


        //tertiary institution subjects
        PdfPCell cell7 = new PdfPCell(new Paragraph("Duties"));
        PdfPCell cell8 = new PdfPCell(new Paragraph(": " + CvDataModel.getInstance().getWorkEntries()[index].getDutiesString()));
        cell7.setBorder(Rectangle.NO_BORDER);
        cell8.setBorder(Rectangle.NO_BORDER);
        cell7.setPaddingBottom(10);
        cell8.setPaddingBottom(10);
        PdfPCell Dutiescells[] = new PdfPCell[]{cell7, cell8};
        PdfPRow DutiesRow = new PdfPRow(Dutiescells);
        sectionTable.getRows().add(DutiesRow);

        document.add(sectionTable);

    }

    private void addReferenceSectionContent(Document document) throws DocumentException
    {
        PdfPTable sectionTable = new PdfPTable(4);
        sectionTable.getDefaultCell().setBorder(Rectangle.NO_BORDER);

         PdfPRow headerRow = addReferenceEntry(null);
         sectionTable.getRows().add(headerRow);

        for(int i = 0; i < CvDataModel.getInstance().getReferencesModels().length; i++)
        {
            if(CvDataModel.getInstance().getReferencesModels()[i] != null && !CvDataModel.getInstance().getReferencesModels()[i].getReferenceName().equals(""))
            {
                PdfPRow Itemrow = addReferenceEntry(CvDataModel.getInstance().getReferencesModels()[i]);
                sectionTable.getRows().add(Itemrow);
            }
        }

        document.add(sectionTable);

    }

    private PdfPRow addReferenceEntry(ReferencesModel referencesModel)
    {

        if(referencesModel == null) {

            PdfPCell cell1 = new PdfPCell(new Paragraph("Names"));
            PdfPCell cell2 = new PdfPCell(new Paragraph("Relationship"));
            PdfPCell cell3 = new PdfPCell(new Paragraph("Cell No"));
            PdfPCell cell4 = new PdfPCell(new Paragraph("Email Address"));
            PdfPCell cells[] = new PdfPCell[]{cell1, cell2, cell3, cell4};
            PdfPRow Row = new PdfPRow(cells);
            return Row;
        }
        else
        {
            PdfPCell cell1 = new PdfPCell(new Paragraph(referencesModel.getReferenceName()));
            PdfPCell cell2 = new PdfPCell(new Paragraph(referencesModel.getRelationship()));
            PdfPCell cell3 = new PdfPCell(new Paragraph(referencesModel.getCellNo()));
            PdfPCell cell4 = new PdfPCell(new Paragraph(referencesModel.getEmailAddress()));
            PdfPCell cells[] = new PdfPCell[]{cell1, cell2, cell3, cell4};
            PdfPRow Row = new PdfPRow(cells);
            return Row;
        }

    }

    private void addEducationalTertiarySectionContent(Document document, int index) throws DocumentException{

        PdfPTable sectionTable = new PdfPTable(2);
        sectionTable.getDefaultCell().setBorder(Rectangle.NO_BORDER);


        //tertiary institution
        PdfPCell cell1 = new PdfPCell(new Paragraph("Institution Name"));
        PdfPCell cell2 = new PdfPCell(new Paragraph(": " + CvDataModel.getInstance().getTertiarySchoolModels()[index].getSchoolName()));
        cell1.setBorder(Rectangle.NO_BORDER);
        cell2.setBorder(Rectangle.NO_BORDER);
        cell1.setPaddingBottom(10);
        cell2.setPaddingBottom(10);
        PdfPCell SchoolNamecells[] = new PdfPCell[]{cell1, cell2};
        PdfPRow SchoolNameRow = new PdfPRow(SchoolNamecells);
        sectionTable.getRows().add(SchoolNameRow);


        //tertiary institution qualification
        PdfPCell cell3 = new PdfPCell(new Paragraph("Qualification Obtained"));
        PdfPCell cell4 = new PdfPCell(new Paragraph(": " + CvDataModel.getInstance().getTertiarySchoolModels()[index].getQualificationLevel()));
        cell3.setBorder(Rectangle.NO_BORDER);
        cell4.setBorder(Rectangle.NO_BORDER);
        cell3.setPaddingBottom(10);
        cell4.setPaddingBottom(10);
        PdfPCell qualificationcells[] = new PdfPCell[]{cell3, cell4};
        PdfPRow qualificationRow = new PdfPRow(qualificationcells);
        sectionTable.getRows().add(qualificationRow);


        //tertiary institution year
        PdfPCell cell5 = new PdfPCell(new Paragraph("Year Obtained"));
        PdfPCell cell6 = new PdfPCell(new Paragraph(": " + CvDataModel.getInstance().getTertiarySchoolModels()[index].getYear()));
        cell5.setBorder(Rectangle.NO_BORDER);
        cell6.setBorder(Rectangle.NO_BORDER);
        cell5.setPaddingBottom(10);
        cell6.setPaddingBottom(10);
        PdfPCell Yearcells[] = new PdfPCell[]{cell5, cell6};
        PdfPRow YearRow = new PdfPRow(Yearcells);
        sectionTable.getRows().add(YearRow);


        //tertiary institution subjects
        PdfPCell cell7 = new PdfPCell(new Paragraph("Subjects"));
        PdfPCell cell8 = new PdfPCell(new Paragraph(": " + CvDataModel.getInstance().getTertiarySchoolModels()[index].getSubjectsString()));
        cell7.setBorder(Rectangle.NO_BORDER);
        cell8.setBorder(Rectangle.NO_BORDER);
        cell7.setPaddingBottom(10);
        cell8.setPaddingBottom(10);
        PdfPCell subjectscells[] = new PdfPCell[]{cell7, cell8};
        PdfPRow subjectsRow = new PdfPRow(subjectscells);
        sectionTable.getRows().add(subjectsRow);

        document.add(sectionTable);

    }

    private void addEducationalSecondarySectionContent(Document document)throws DocumentException{


        PdfPTable sectionTable = new PdfPTable(2);
        sectionTable.getDefaultCell().setBorder(Rectangle.NO_BORDER);


        //Secondary School
        PdfPCell cell1 = new PdfPCell(new Paragraph("School Name"));
        PdfPCell cell2 = new PdfPCell(new Paragraph(": " + CvDataModel.getInstance().getSecondarySchoolModels()[0].getSchoolName()));
        cell1.setBorder(Rectangle.NO_BORDER);
        cell2.setBorder(Rectangle.NO_BORDER);
        cell1.setPaddingBottom(10);
        cell2.setPaddingBottom(10);
        PdfPCell SchoolNamecells[] = new PdfPCell[]{cell1, cell2};
        PdfPRow SchoolNameRow = new PdfPRow(SchoolNamecells);
        sectionTable.getRows().add(SchoolNameRow);

        //Secondary School grade
        PdfPCell cell3 = new PdfPCell(new Paragraph("Highest Grade Passed"));
        PdfPCell cell4 = new PdfPCell(new Paragraph(": " + CvDataModel.getInstance().getSecondarySchoolModels()[0].getHighestLevel()));
        cell3.setBorder(Rectangle.NO_BORDER);
        cell4.setBorder(Rectangle.NO_BORDER);
        cell3.setPaddingBottom(10);
        cell4.setPaddingBottom(10);
        PdfPCell gradecells[] = new PdfPCell[]{cell3, cell4};
        PdfPRow gradeRow = new PdfPRow(gradecells);
        sectionTable.getRows().add(gradeRow);

        //Secondary School year
        PdfPCell cell5 = new PdfPCell(new Paragraph("Year"));
        PdfPCell cell6 = new PdfPCell(new Paragraph(": " + CvDataModel.getInstance().getSecondarySchoolModels()[0].getYear()));
        cell5.setBorder(Rectangle.NO_BORDER);
        cell6.setBorder(Rectangle.NO_BORDER);
        cell5.setPaddingBottom(10);
        cell6.setPaddingBottom(10);
        PdfPCell Yearcells[] = new PdfPCell[]{cell5, cell6};
        PdfPRow YearRow = new PdfPRow(Yearcells);
        sectionTable.getRows().add(YearRow);

        //Secondary School subjects
        PdfPCell cell7 = new PdfPCell(new Paragraph("Subjects"));
        PdfPCell cell8 = new PdfPCell(new Paragraph(": " + CvDataModel.getInstance().getSecondarySchoolModels()[0].getSubjectsString()));
        cell7.setBorder(Rectangle.NO_BORDER);
        cell8.setBorder(Rectangle.NO_BORDER);
        cell7.setPaddingBottom(10);
        cell8.setPaddingBottom(10);
        PdfPCell subjectscells[] = new PdfPCell[]{cell7, cell8};
        PdfPRow subjectsRow = new PdfPRow(subjectscells);
        sectionTable.getRows().add(subjectsRow);


        //Secondary School murals
        PdfPCell cell9 = new PdfPCell(new Paragraph("Extra Mural Activities"));
        PdfPCell cell10 = new PdfPCell(new Paragraph(": " + CvDataModel.getInstance().getSecondarySchoolModels()[0].getMuralsString()));
        cell9.setBorder(Rectangle.NO_BORDER);
        cell10.setBorder(Rectangle.NO_BORDER);
        cell9.setPaddingBottom(10);
        cell10.setPaddingBottom(10);
        PdfPCell muralscells[] = new PdfPCell[]{cell9, cell10};
        PdfPRow muralsRow = new PdfPRow(muralscells);
        sectionTable.getRows().add(muralsRow);


        document.add(sectionTable);

    }

    private void addPersonalSectionContent(Document document) throws DocumentException {


        PdfPTable sectionTable = new PdfPTable(2);
        sectionTable.getDefaultCell().setBorder(Rectangle.NO_BORDER);

        //First names
        PdfPCell cell1 = new PdfPCell(new Paragraph("Full Names"));
        PdfPCell cell2 = new PdfPCell(new Paragraph(": " + CvDataModel.getInstance().getFirstName() + " " + CvDataModel.getInstance().getMiddleName()));
        cell1.setBorder(Rectangle.NO_BORDER);
        cell2.setBorder(Rectangle.NO_BORDER);
        cell1.setPaddingBottom(10);
        cell2.setPaddingBottom(10);
        PdfPCell firstcells[] = new PdfPCell[]{cell1, cell2};
        PdfPRow firstNamesRow = new PdfPRow(firstcells);
        sectionTable.getRows().add(firstNamesRow);

        //Last name
        PdfPCell cell3 = new PdfPCell(new Paragraph("Last Name"));
        PdfPCell cell4 = new PdfPCell(new Paragraph(": " + CvDataModel.getInstance().getLastName()));
        cell3.setBorder(Rectangle.NO_BORDER);
        cell4.setBorder(Rectangle.NO_BORDER);
        cell3.setPaddingBottom(10);
        cell4.setPaddingBottom(10);
        PdfPCell secondcells[] = new PdfPCell[]{cell3, cell4};
        PdfPRow LastNameRow = new PdfPRow(secondcells);
        sectionTable.getRows().add(LastNameRow);

        //Gender
        PdfPCell cell5 = new PdfPCell(new Paragraph("Gender"));
        PdfPCell cell6 = new PdfPCell(new Paragraph(": " + CvDataModel.getInstance().getGender()));
        cell5.setBorder(Rectangle.NO_BORDER);
        cell6.setBorder(Rectangle.NO_BORDER);
        cell5.setPaddingBottom(10);
        cell6.setPaddingBottom(10);
        PdfPCell gendercells[] = new PdfPCell[]{cell5, cell6};
        PdfPRow genderRow = new PdfPRow(gendercells);
        sectionTable.getRows().add(genderRow);

        //Date of Birth
       // PdfPCell cell7 = new PdfPCell(new Paragraph("Date O birth"));
       // PdfPCell cell8 = new PdfPCell(new Paragraph(": " + CvDataModel.getInstance().getDob().toString()));
       // cell7.setBorder(Rectangle.NO_BORDER);
        //cell8.setBorder(Rectangle.NO_BORDER);
      //  cell7.setPaddingBottom(10);
        //cell8.setPaddingBottom(10);
      //  PdfPCell dobcells[] = new PdfPCell[]{cell7, cell8};
       // PdfPRow dobRow = new PdfPRow(dobcells);
       // sectionTable.getRows().add(dobRow);


        //Nationality
        PdfPCell cell9 = new PdfPCell(new Paragraph("Nationality"));
        PdfPCell cell10 = new PdfPCell(new Paragraph(": " + CvDataModel.getInstance().getNationality()));
        cell9.setBorder(Rectangle.NO_BORDER);
        cell10.setBorder(Rectangle.NO_BORDER);
        cell9.setPaddingBottom(10);
        cell10.setPaddingBottom(10);
        PdfPCell nationalitycells[] = new PdfPCell[]{cell9, cell10};
        PdfPRow nationalityRow = new PdfPRow(nationalitycells);
        sectionTable.getRows().add(nationalityRow);

        //Marital
        PdfPCell cell11 = new PdfPCell(new Paragraph("Marital Status"));
        PdfPCell cell12 = new PdfPCell(new Paragraph(": " + CvDataModel.getInstance().getMaritalStatus()));
        cell11.setBorder(Rectangle.NO_BORDER);
        cell12.setBorder(Rectangle.NO_BORDER);
        cell11.setPaddingBottom(10);
        cell12.setPaddingBottom(10);
        PdfPCell Maritcalcells[] = new PdfPCell[]{cell11, cell12};
        PdfPRow MaritalRow = new PdfPRow(Maritcalcells);
        sectionTable.getRows().add(MaritalRow);

        //Postal Address
        PdfPCell cell13 = new PdfPCell(new Paragraph("Postal Address"));
        PdfPCell cell14 = new PdfPCell(new Paragraph(": " + CvDataModel.getInstance().getPostalAddress()));
        cell13.setBorder(Rectangle.NO_BORDER);
        cell14.setBorder(Rectangle.NO_BORDER);
        cell13.setPaddingBottom(10);
        cell14.setPaddingBottom(10);
        PdfPCell Postalcells[] = new PdfPCell[]{cell13, cell14};
        PdfPRow PostalRow = new PdfPRow(Postalcells);
        sectionTable.getRows().add(PostalRow);


        //Residential Address
        PdfPCell cell15 = new PdfPCell(new Paragraph("Residential Address"));
        PdfPCell cell16 = new PdfPCell(new Paragraph(": " + CvDataModel.getInstance().getResAddress()));
        cell15.setBorder(Rectangle.NO_BORDER);
        cell16.setBorder(Rectangle.NO_BORDER);
        cell15.setPaddingBottom(10);
        cell16.setPaddingBottom(10);
        PdfPCell Residentialcells[] = new PdfPCell[]{cell15, cell16};
        PdfPRow ResidetialRow = new PdfPRow(Residentialcells);
        sectionTable.getRows().add(ResidetialRow);


        //Cell No
        PdfPCell cell17 = new PdfPCell(new Paragraph("Cell No"));
        PdfPCell cell18 = new PdfPCell(new Paragraph(": " + CvDataModel.getInstance().getCellNo()));
        cell17.setBorder(Rectangle.NO_BORDER);
        cell18.setBorder(Rectangle.NO_BORDER);
        cell17.setPaddingBottom(10);
        cell18.setPaddingBottom(10);
        PdfPCell cellNocells[] = new PdfPCell[]{cell17, cell18};
        PdfPRow cellNoRow = new PdfPRow(cellNocells);
        sectionTable.getRows().add(cellNoRow);


        //Email
        PdfPCell cell19 = new PdfPCell(new Paragraph("Email Address"));
        PdfPCell cell20 = new PdfPCell(new Paragraph(": " + CvDataModel.getInstance().getEmailAddress()));
        cell19.setBorder(Rectangle.NO_BORDER);
        cell20.setBorder(Rectangle.NO_BORDER);
        cell19.setPaddingBottom(10);
        cell20.setPaddingBottom(10);
        PdfPCell Emailcells[] = new PdfPCell[]{cell19, cell20};
        PdfPRow EmailRow = new PdfPRow(Emailcells);
        sectionTable.getRows().add(EmailRow);


        document.add(sectionTable);

    }

}
