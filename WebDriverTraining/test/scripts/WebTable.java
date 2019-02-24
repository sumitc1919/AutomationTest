package scripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;

public class WebTable 
{
	private WebElement webTbl;
	
	public WebTable(WebElement webTbl) 	//Constructor
	{
		String tagName=webTbl.getTagName();
		
		if(null==tagName|| !"table".equals(tagName.toLowerCase()))
		{
			throw new UnexpectedTagNameException("table", tagName);
		}
		this.webTbl=webTbl;
	}
	
	
	public int getRowCount()
	{
		List<WebElement> allRows=webTbl.findElements(By.tagName("tr"));
		return allRows.size();
	}
	
	public int getColCount()
	{
		List<WebElement> allRows=webTbl.findElements(By.tagName("tr"));
		WebElement headRow=allRows.get(0);
		List<WebElement> tableCols=headRow.findElements(By.tagName("th"));
		return tableCols.size();
	}
	
	public String getCellData(int rowId,int colId)
	{
		List<WebElement> allRows=webTbl.findElements(By.tagName("tr"));
		WebElement currentRow=allRows.get(rowId-1);
		List<WebElement> tableCols=currentRow.findElements(By.tagName("td"));
		WebElement cell=tableCols.get(colId-1);
		return cell.getText();
	}
	
	public WebElement clickOnDelete(String columnHeaderName, String toSearch)
	{
		List<WebElement> allRows = webTbl.findElements(By.tagName("tr"));
		WebElement headerRow = allRows.get(0);
		List<WebElement> allHeaderColumns = headerRow.findElements(By.tagName("th"));
		int i = 0;
		int targetColumn = 0;
		for (WebElement oneHeaderCol : allHeaderColumns)
		{
			i++;
			if (oneHeaderCol.getText().contains(columnHeaderName))
			{
				targetColumn = i;
				System.out.println(oneHeaderCol.getText());
			    break;
			}
		}
		WebElement btn=webTbl.findElement(By.xpath("//table[@id='table2']//td//a[contains(text(),'delete')]"));
		btn.click();
		return headerRow;
	}
}
