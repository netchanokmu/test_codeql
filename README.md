# CodeQL Workflows
ในโปรเจ็กต์นี้ เป็นตัวอย่างของการเขียน workflows เพื่อใช้ CodeQL เพื่อสแกนโค้ดในภาษาต่าง ๆ เช่น Python
, Java, .NET และ Terraform 

## Project Structure

- **.github/workflows:**
  - dotnet-scan
  - java-scan
  - python-scan
  - terraform-scan

- **dotnet-code-folder:** 
- **java-code-folder:** 
- **python-code-folder:** 
- **terraform-code-folder:** 

### Workflows
โฟลเดอร์ .github/workflows มี workflows ที่ใช้สำหรับการสแกนโค้ดในภาษาต่าง ๆ ซึ่งประกอบไปด้วย
- **dotnet-scan:** Workflow สำหรับสแกนโค้ด .NET
- **java-scan:** Workflow สำหรับสแกนโค้ด Java
- **python-scan:** Workflow สำหรับสแกนโค้ด Python
- **terraform-scan:** Workflow สำหรับสแกนโค้ด Terraform

### Code Folders
โฟลเดอร์ dotnet -code-folder, java -code-folder, python-folder และ terraform-code-folder ประกอบไปด้วยตัวอย่างโค้ดที่เขียนด้วยภาษาที่กำหนด

## การใช้งาน CodeQL ใน workflows
### -ในกรณีของภาษา .NET, Java และ Python จะใช้ github/codeql-action
ทำการเพิ่ม step ต่อไปนี้ใน workflow

1. **Initializes the CodeQL tools สำหรับการสแกน**
   ```yaml
   - name: Initialize CodeQL
     uses: github/codeql-action/init@v1
     with:
       languages: ${{ matrix.language }}

2. **Autobuild attempts to build any compiled languages  (C/C++, C#, or Java)**
    ```yaml
    - name: Autobuild
      uses: github/codeql-action/autobuild@v1

โดยขั้นตอนนี้จะเป็นการ build โค้ดให้อัตโนมัติ

3. **Scan and analyze CodeQL code on the repository**
    ```yaml
    - name: Perform CodeQL Analysis
      uses: github/codeql-action/analyze@v1

### -ในกรณีของ Terraform จะใช้ advanced-security/codeql-extractor-iac 
ทำการเพิ่ม step ต่อไปนี้ใน workflow

1. **Initialize and Analyze IaC**
   ```yaml
    - name: Initialize and Analyze IaC
      id: codeql_iac
      uses: advanced-security/codeql-extractor-iac@main


2. **Upload SARIF file**
เนื่องจาก CodeQL Extractor จะสร้างไฟล์ SARIF แต่จะไม่อัปโหลดให้ ดังนั้นจะต้องใช้ github/codeql-action/upload-sarif เพื่อทำการอัปโหลดเอง

    ```yaml
    - name: Upload SARIF file
      uses: github/codeql-action/upload-sarif@v2
      with:
      sarif_file: codeql-iac.sarif
