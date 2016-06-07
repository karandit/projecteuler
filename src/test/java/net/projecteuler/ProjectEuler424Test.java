package net.projecteuler;

import static net.projecteuler.ProjectEuler424.solveKakuro;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ProjectEuler424Test {

    @Test
    public void shouldSolve_Kakuro001() {
        assertKakuro(8426039571L, "6,X,X,(vCC),(vI),X,X,X,(hH),B,O,(vCA),(vJE),X,(hFE,vD),O,O,O,O,(hA),O,I,(hJC,vB),O,O,(hJC),H,O,O,O,X,X,X,(hJE),O,O,X");
    }

    @Test
    public void shouldSolve_Kakuro002() {
        assertKakuro(8519647302L, "7,X,X,X,X,(vJJ),(vCD),X,X,X,X,(hCG),O,O,(vCE),X,X,X,(hCI,vJB),C,O,O,X,(vB),(hJF,vJF),O,F,O,O,(hJA),F,G,O,O,X,X,(hCA),O,A,O,X,X,X,X,(hCF),O,O,X,X,X");
    }

    @Test
    public void shouldSolve_Kakuro003() {
        assertKakuro(3019652784L, "7,X,X,X,(vE),(vCB),X,X,X,X,(hJ),O,O,(vCA),X,X,(vCH),(hCG,vCJ),O,O,O,(vJ),(hCE),O,O,O,(hJ,vGG),O,O,(hD),I,O,(hCD,vCB),H,O,O,X,(hCE),O,O,E,X,X,X,X,(hCE),O,O,X,X");
    }

    @Test
    public void shouldSolve_Kakuro004() {
        assertKakuro(6457280931L, "6,X,X,X,(vEA),(vJF),X,X,X,(hI),O,O,(vJA),X,(vA),(hEI,vEB),O,O,O,(hIG),C,O,J,O,D,(hJD),O,O,O,X,X,X,(hJD),O,O,X,X");
    }

    @Test
    public void shouldSolve_Kakuro005() {
        assertKakuro(9251083647L, "7,X,(vH),(vG),X,X,(vI),(vDH),(hG),B,O,(vDI),(hDB,vDE),O,O,(hBC),I,O,F,O,O,J,X,X,(hG),O,O,X,X,X,(vDG),(hH,vDD),O,O,(vDJ),(vC),(hBI),O,O,O,O,O,O,(hDJ),O,O,X,(hA),O,O");
    }

    @Test
    public void shouldSolve_Kakuro006() {
        assertKakuro(5236479810L, "6,X,(vID),(vIJ),X,X,X,(hH),F,I,(vF),(vIA),X,(hIA),G,B,O,C,X,X,(hID),O,O,O,(vIF),X,(hIA),E,O,I,O,X,X,X,(hII),O,G");
    }

    @Test
    public void shouldSolve_Kakuro007() {
        assertKakuro(1348672905L, "6,X,X,(vAF),(vAI),X,X,X,(hJ,vAC),O,B,(vGJ),X,(hGH),J,O,O,O,(vAF),(hAG),O,O,(hH,vF),A,D,X,(hGF),O,E,O,O,X,X,(hD),O,O,X");
    }

    @Test
    public void shouldSolve_Kakuro008() {
        assertKakuro(5417093862L, "7,X,X,X,X,(vCE),(vGB),X,X,(vJG),(vCI),(hCD,vCJ),O,O,X,(hCI),O,O,O,O,B,(vJB),(hCF),O,O,O,(hCA,vH),O,O,(hCJ),O,O,(hJB,vCJ),O,O,O,X,(hJD),O,O,O,O,O,X,(hF),I,O,X,X,X");
    }

    @Test
    public void shouldSolve_Kakuro009() {
        assertKakuro(8190245736L, "7,X,(vBB),(vBD),X,X,X,X,(hBB),C,E,(vEE),(vEC),X,X,(hBC),O,O,O,O,X,X,X,(hEF),H,O,A,(vJ),X,X,X,(hBD),O,O,O,(vI),X,X,(hBE),F,O,O,O,X,X,X,X,(hG),O,O");
    }

    @Test
    public void shouldSolve_Kakuro010() {
        assertKakuro(8547961032L, "7,X,X,(vGG),(vGD),X,(vI),(vGI),X,(hGB),O,O,(hGH,vIC),O,O,X,(hGA),O,O,O,J,O,X,X,(hGI),O,O,X,X,X,(vGD),(hE,vE),O,O,(vGF),X,(hIH),O,O,O,O,O,X,(hE),A,O,(hGF),O,O,X");
    }

    @Test
    public void shouldSolve_Kakuro011() {
        assertKakuro(4027398516L, "6,X,(vIJ),(vIE),X,X,X,(hF),O,C,(vIA),X,X,(hCA),O,O,D,(vIH),X,X,(hIB),E,O,O,(vF),X,X,(hD),O,A,O,X,X,X,(hID),O,G");
    }

    @Test
    public void shouldSolve_Kakuro012() {
        assertKakuro(2983751046L, "6,X,(vAD),(vGI),(vI),X,X,(hB),O,O,O,(vAF),X,(hGC),O,O,O,O,(vGA),(hGE),O,O,(hJ,vB),O,O,X,(hGD),D,O,E,O,X,X,(hAI),O,C,O");
    }

    @Test
    public void shouldSolve_Kakuro013() {
        assertKakuro(3098526174L, "6,X,X,X,(vAB),(vFA),X,X,X,(hHI),O,O,(vHJ),X,(vA),(hFJ,vHE),I,D,O,(hFH),O,O,O,O,O,(hHJ),O,O,O,X,X,X,(hC),O,J,X,X");
    }

    @Test
    public void shouldSolve_Kakuro014() {
        assertKakuro(7538102946L, "7,X,X,X,(vJ),(vEF),X,X,X,X,(hI,vGD),C,E,(vEF),(vA),X,(hEH),O,O,O,O,O,X,(hH,vJ),O,O,(hJ,vEJ),O,O,(hD),O,A,(hEF,vEB),O,O,X,(hCC),O,O,A,O,O,X,X,X,(hH),O,O,X,X");
    }

    @Test
    public void shouldSolve_Kakuro015() {
        assertKakuro(1584320967L, "7,X,X,X,(vAG),(vAJ),(vFH),X,X,X,(hFD),O,O,O,X,X,(vH),(hAJ,vAB),O,O,O,(vB),(hAH),O,H,O,(hC,vAI),O,O,(hE),O,O,(hAI,vAE),O,O,O,X,(hJ),O,O,O,X,X,X,(hFG),E,O,O,X,X");
    }

    @Test
    public void shouldSolve_Kakuro016() {
        assertKakuro(1589704362L, "7,X,(vAI),(vHB),X,X,(vJE),(vAA),(hD),O,O,X,(hG),O,O,(hAJ),O,O,(vE),(hAA,vAI),O,O,X,(hHF),O,O,O,O,X,X,(hJF,vAE),O,O,O,J,(vH),(hAI),D,O,X,(hB),O,O,(hAG),O,O,X,(hAA),O,O");
    }

    @Test
    public void shouldSolve_Kakuro017() {
        assertKakuro(1543609278L, "7,X,X,(vHJ),(vC),(vAF),X,X,X,(hHF),O,O,O,(vHI),(vHD),X,(hHB,vAB),O,O,O,O,E,(hAI),O,O,X,(hAB),O,O,(hD),O,O,(vAB),(hAI,vE),J,O,(hHH),O,O,O,B,O,X,X,X,(hG),O,A,O,X");
    }

    @Test
    public void shouldSolve_Kakuro018() {
        assertKakuro(5782930164L, "6,X,X,(vDF),(vHE),X,X,X,(hHJ,vE),C,O,X,X,(hHI),O,O,O,(vDF),(vHH),(hFA),A,O,B,O,O,X,X,(hE),O,I,O,X,X,(hHH),O,O,X");
    }

    @Test
    public void shouldSolve_Kakuro019() {
        assertKakuro(6827459130L, "6,X,(vA),(vA),X,X,X,(hE),O,O,(vCJ),X,X,(hG),O,O,O,(vHI),X,X,(hHC),O,O,H,(vB),X,X,(hCE),O,O,D,X,X,X,(hE),O,O");
    }

    @Test
    public void shouldSolve_Kakuro020() {
        assertKakuro(4762183509L, "6,X,X,X,X,(vEH),(vEC),X,X,X,(hEB,vEJ),O,O,X,X,(hEC,vEF),O,O,B,X,(hDD,vEI),O,B,C,X,(hB),O,D,A,X,X,(hEC),O,O,X,X,X");
    }

    @Test
    public void shouldSolve_Kakuro021() {
        assertKakuro(5974682310L, "6,X,X,X,X,(vIF),(vH),X,X,X,(hIJ,vGJ),B,I,X,X,(hIB,vIC),O,O,G,X,(hIA,vC),O,O,O,X,(hE),O,O,O,X,X,(hIA),E,O,X,X,X");
    }

    @Test
    public void shouldSolve_Kakuro022() {
        assertKakuro(6342517098L, "7,X,(vC),(vFB),X,X,X,X,(hFH),O,O,(vFA),(vFJ),(vC),X,(hFJ),O,O,O,O,O,X,X,X,(hA,vJ),O,O,O,X,X,(hG),D,O,O,(vC),(vFC),X,(hBH),A,O,O,O,E,X,X,X,X,(hFH),O,I");
    }

    @Test
    public void shouldSolve_Kakuro023() {
        assertKakuro(6431827059L, "6,X,X,(vFD),(vC),X,X,X,(hDH),E,F,(vDG),(vDD),X,(hDF,vDI),O,O,A,O,(hDG),O,O,(hDG,vDG),O,O,(hDJ),O,D,J,O,X,X,X,(hJ),E,O,X");
    }

    @Test
    public void shouldSolve_Kakuro024() {
        assertKakuro(3506891427L, "6,X,X,X,(vE),(vGH),(vIC),X,X,(hD,vIG),O,O,A,X,(hIF,vJ),O,J,E,O,(hJ),O,D,(hGG,vGH),O,O,(hGG),O,O,O,O,X,(hIC),O,O,O,X,X");
    }

    @Test
    public void shouldSolve_Kakuro025() {
        assertKakuro(2683704591L, "7,X,X,X,X,(vAG),(vJA),(vH),X,X,X,(hAJ,vDJ),O,O,O,X,X,(hJF),O,O,O,O,X,X,(hG),D,O,X,X,X,(vJH),(hJE,vJD),C,I,X,X,(hAE),B,O,O,O,X,X,(hAJ),O,O,E,X,X,X");
    }

    @Test
    public void shouldSolve_Kakuro026() {
        assertKakuro(4597061328L, "7,X,X,X,X,(vGG),(vIA),(vGF),X,X,X,(hGF),O,O,D,X,X,X,(hGJ,vIB),O,O,O,X,X,(hGH,vGD),O,O,O,X,X,(hII,vC),O,J,O,X,X,(hIH),J,O,O,X,X,X,(hGE),O,I,O,X,X,X");
    }

    @Test
    public void shouldSolve_Kakuro027() {
        assertKakuro(8042316759L, "6,X,X,(vFA),(vEC),X,X,X,(hI,vFI),F,O,X,X,(hDE),O,O,O,(vFF),(vFF),(hDI),G,J,O,F,O,X,X,(hFJ),O,D,O,X,X,(hFH),J,A,X");
    }

    @Test
    public void shouldSolve_Kakuro028() {
        assertKakuro(3109475628L, "7,X,X,X,X,X,(vID),(vBB),X,X,X,X,(hBC),O,I,X,X,(vIH),(vBH),(hBF,vF),O,O,X,(hIE,vD),O,O,I,O,O,(hAG),O,O,O,O,F,X,(hA),O,O,X,X,X,X,(hD),O,O,X,X,X,X");
    }

    @Test
    public void shouldSolve_Kakuro029() {
        assertKakuro(8514623079L, "7,X,(vCD),(vCC),X,X,X,X,(hE),B,C,(vCE),X,X,X,(hCD),O,O,O,(vE),(vCG),X,X,(hCH),O,O,O,O,X,X,(hFC),B,J,G,O,(vCC),X,X,X,(hCI),O,O,O,X,X,X,X,(hG),O,O");
    }

    @Test
    public void shouldSolve_Kakuro030() {
        assertKakuro(6597430812L, "7,X,X,X,(vID),(vD),(vFB),X,X,X,(hIB,vID),O,O,O,X,X,(hJE,vIA),J,C,O,D,(vF),(hIB),O,O,X,(hIG),O,O,(hIJ),O,O,(vD),(hA,vID),O,O,X,(hJF),O,O,O,O,X,X,(hIE),O,O,O,X,X");
    }

    @Test
    public void shouldSolve_Kakuro031() {
        assertKakuro(1427859360L, "7,X,X,(vAC),(vAH),X,X,X,X,(hD),O,O,(vAD),X,X,X,(hCH,vAD),O,O,O,(vAA),(vF),(hAC),O,H,(hAB,vAJ),O,O,A,(hAE),O,O,O,(hD,vAD),O,O,X,X,(hAC),O,O,O,X,X,X,X,(hG),O,O,X");
    }

    @Test
    public void shouldSolve_Kakuro032() {
        assertKakuro(3187654290L, "6,X,X,(vBB),(vBE),X,X,X,(hBH),O,I,(vBG),(vBB),X,(hHE,vBD),H,D,O,O,(hBA),C,O,(hA,vG),O,O,(hBF),I,O,O,O,X,X,X,(hG),O,O,X");
    }

    @Test
    public void shouldSolve_Kakuro033() {
        assertKakuro(6907382514L, "6,X,X,(vEC),(vD),X,X,X,(hD,vH),O,O,(vIB),X,(hIA),O,O,O,O,(vE),(hII),O,F,(hII,vIG),O,O,X,(hIH),O,O,O,O,X,X,(hIA),O,D,X");
    }

    @Test
    public void shouldSolve_Kakuro034() {
        assertKakuro(2638197540L, "6,X,X,X,X,(vEH),(vEG),X,X,X,(hEB,vEF),O,O,X,X,(hAC,vG),O,B,O,X,(hEE,vEC),O,D,O,X,(hEE),O,O,O,X,X,(hEJ),D,O,X,X,X");
    }

    @Test
    public void shouldSolve_Kakuro035() {
        assertKakuro(3714659208L, "6,X,(vD),(vB),X,X,X,(hA),O,O,(vE),X,X,(hE),A,O,O,(vCJ),X,X,(hCH),O,A,O,(vCI),X,X,(hB),O,D,O,X,X,X,(hCB),G,O");
    }

    @Test
    public void shouldSolve_Kakuro036() {
        assertKakuro(9084675213L, "7,X,X,X,X,(vHJ),(vIF),(vIB),X,X,X,(hIH,vJI),O,O,J,X,X,(hIA),O,O,O,F,X,X,(hIG),O,C,X,X,X,(vD),(hA,vIB),O,J,X,X,(hHB),O,O,O,O,X,X,(hHB),O,O,O,X,X,X");
    }

    @Test
    public void shouldSolve_Kakuro037() {
        assertKakuro(5174638920L, "7,X,X,X,(vBJ),(vIB),X,X,X,(vIF),(hBB,vBB),O,O,(vBA),X,(hIC),O,O,O,O,O,(vBA),(hBD),O,O,(hC,vC),O,O,O,(hBJ),E,O,O,(hBC,vBI),G,H,X,(hBA),O,O,O,O,O,X,X,(hBF),O,O,X,X");
    }

    @Test
    public void shouldSolve_Kakuro038() {
        assertKakuro(5764083129L, "7,X,(vHI),(vHE),X,X,X,X,(hA),O,O,X,X,X,X,(hHG),O,O,(vHH),(vHE),(vIJ),X,(hHA),O,O,O,O,O,(vHI),X,(hID),H,O,O,B,I,X,X,X,X,(hHB),F,O,X,X,X,X,(hHE),O,H");
    }

    @Test
    public void shouldSolve_Kakuro039() {
        assertKakuro(1682309457L, "6,X,X,(vAJ),(vAJ),X,X,X,(hAF,vAA),G,A,X,X,(hDA),O,O,O,(vDE),(vAH),(hAJ),O,O,O,O,I,X,X,(hAG),D,C,O,X,X,(hAI),O,O,X");
    }

    @Test
    public void shouldSolve_Kakuro040() {
        assertKakuro(7201869534L, "6,X,X,X,X,(vDH),(vDA),X,X,X,(hG,vDG),O,E,X,X,(hBJ,vBC),O,O,O,X,(hBI,vE),O,E,O,X,(hE),O,O,O,X,X,(hDH),O,E,X,X,X");
    }

    @Test
    public void shouldSolve_Kakuro041() {
        assertKakuro(5924687130L, "6,X,X,X,X,(vHJ),(vHH),X,X,X,(hHE,vCC),O,O,X,X,(hF,vG),A,O,O,X,(hHC,vHJ),O,B,O,X,(hHH),O,O,O,X,X,(hHI),O,O,X,X,X");
    }

    @Test
    public void shouldSolve_Kakuro042() {
        assertKakuro(3452179806L, "7,X,(vJ),(vDG),X,X,(vDF),(vEF),(hC),E,B,X,(hEA),O,O,(hEE),C,O,(vH),(hED,vEF),A,O,X,(hEC),O,O,O,O,X,X,(hDD,vEF),O,O,O,O,(vEA),(hEJ),O,F,X,(hJ),O,O,(hEF),O,O,X,(hEF),O,O");
    }

    @Test
    public void shouldSolve_Kakuro043() {
        assertKakuro(7324809561L, "7,X,X,X,(vCC),(vD),X,X,X,(vJE),(hI,vCH),O,O,(vBF),X,(hCC),O,O,O,O,A,(vJB),(hCB),G,O,O,(hJA,vJF),O,O,(hJA),O,O,(hG,vH),O,O,O,X,(hCE),O,O,O,O,O,X,X,(hH),O,O,X,X");
    }

    @Test
    public void shouldSolve_Kakuro044() {
        assertKakuro(2740158369L, "7,X,X,(vEI),(vEB),(vG),X,X,X,(hEF),E,O,O,(vHE),X,X,(hEF,vH),O,O,O,O,(vEI),(hH),O,O,X,(hEH),O,B,(hG),O,O,(vG),(hEI,vED),O,O,X,(hAG),C,O,O,O,X,X,X,(hEE),O,O,O,X");
    }

    @Test
    public void shouldSolve_Kakuro045() {
        assertKakuro(7640295831L, "6,X,X,X,X,(vJE),(vF),X,X,X,(hI,vJJ),O,O,X,X,(hEC,vJJ),H,O,O,X,(hF,vJB),O,O,O,X,(hJI),A,C,E,X,X,(hJD),O,J,X,X,X");
    }

    @Test
    public void shouldSolve_Kakuro046() {
        assertKakuro(2513064987L, "6,X,X,X,(vH),(vAE),X,X,X,(hCB,vCJ),O,O,(vCB),X,(hCA,vD),O,O,O,O,(hD),C,O,(hCC,vJ),O,O,(hAB),A,O,F,O,X,X,(hB),G,O,X,X");
    }

    @Test
    public void shouldSolve_Kakuro047() {
        assertKakuro(6809137254L, "6,X,X,(vEC),(vEG),X,X,X,(hEF),O,O,(vFC),(vEI),X,(hHJ,vJ),E,O,O,A,(hJ),O,O,(hEA,vEA),O,O,(hHH),O,O,O,B,X,X,X,(hEF),O,O,X");
    }

    @Test
    public void shouldSolve_Kakuro048() {
        assertKakuro(9047183526L, "7,X,(vEI),(vEC),X,X,X,X,(hH),O,O,X,X,X,X,(hED),O,O,(vEB),(vEG),(vGB),X,(hEJ),O,O,O,O,O,(vD),X,(hIA),O,O,O,O,C,X,X,X,X,(hA),O,I,X,X,X,X,(hEB),A,O");
    }

    @Test
    public void shouldSolve_Kakuro049() {
        assertKakuro(5189376024L, "7,X,X,X,(vF),(vG),(vIB),X,X,(vG),(hBA,vIH),J,I,D,X,(hBG),O,O,O,O,O,(vBG),(hA),O,O,X,(hE),O,O,(hBB),O,C,(vA),(hBI,vBE),O,O,X,(hBA),O,O,O,O,O,X,(hBF),O,O,O,X,X");
    }

    @Test
    public void shouldSolve_Kakuro050() {
        assertKakuro(4301265978L, "7,X,X,(vEF),(vDI),X,X,X,X,(hDG),O,O,(vDA),X,X,X,(hEA,vG),O,O,O,(vEJ),(vJ),(hF),O,G,(hDH,vDI),O,O,F,(hED),O,O,O,(hDD,vB),O,O,X,X,(hDB),O,O,A,X,X,X,X,(hH),O,O,X");
    }

    @Test
    public void shouldSolve_Kakuro051() {
        assertKakuro(1483069572L, "7,X,X,X,X,(vJH),(vD),(vAJ),X,X,X,(hAC,vDH),O,O,O,X,X,(hAA),O,O,O,O,X,X,(hC),F,O,X,X,X,(vC),(hAJ,vAA),I,H,X,X,(hJA),O,D,O,G,X,X,(hJB),O,C,O,X,X,X");
    }

    @Test
    public void shouldSolve_Kakuro052() {
        assertKakuro(8913547602L, "6,X,X,X,(vDC),(vG),X,X,X,(hA),O,O,(vCH),X,(vCI),(hCB,vB),O,O,O,(hDF),O,H,O,O,O,(hH),O,O,O,X,X,X,(hH),J,O,X,X");
    }

    @Test
    public void shouldSolve_Kakuro053() {
        assertKakuro(6325891074L, "6,X,X,(vCG),(vGA),X,X,X,(hE),O,O,(vGG),(vGB),X,(hCI,vF),O,O,O,I,(hGI),O,O,(hI,vD),O,A,(hGH),O,B,O,O,X,X,X,(hA),O,O,X");
    }

    @Test
    public void shouldSolve_Kakuro054() {
        assertKakuro(4387562109L, "6,X,X,X,(vJ),(vHF),X,X,(vF),(hHG,vHD),O,A,X,(hHI),A,O,O,O,(vHE),(hB),G,O,(hD,vHE),O,F,X,(hGJ),O,O,O,O,X,(hHD),O,O,X,X");
    }

    @Test
    public void shouldSolve_Kakuro055() {
        assertKakuro(9184703265L, "6,X,X,X,X,(vBD),(vD),X,X,X,(hD,vBB),O,O,X,X,(hI,vHD),O,O,O,X,(hHD,vBE),O,O,A,X,(hHF),C,O,G,X,X,(hBI),O,O,X,X,X");
    }

    @Test
    public void shouldSolve_Kakuro056() {
        assertKakuro(4092716853L, "7,X,(vJ),(vFB),(vDB),X,X,X,(hFC),O,O,O,(vFE),X,X,(hFB),O,O,O,O,X,X,X,X,(hG),I,O,X,X,X,X,(hA),O,O,(vFG),(vE),X,X,(hDD),O,O,O,A,X,X,X,(hFD),D,E,J");
    }

    @Test
    public void shouldSolve_Kakuro057() {
        assertKakuro(1867295043L, "6,X,X,X,(vAD),(vAH),X,X,(vB),(hF,vEB),O,O,X,(hED),O,O,O,O,(vD),(hD),O,O,(hJ,vI),O,O,X,(hEH),O,A,O,C,X,(hB),G,O,X,X");
    }

    @Test
    public void shouldSolve_Kakuro058() {
        assertKakuro(643812975L, "6,X,X,X,X,(vFG),(vFB),X,X,X,(hFD,vB),O,O,X,X,(hFG,vFG),O,O,O,X,(hI,vH),O,O,C,X,(hGA),E,H,O,X,X,(hD),O,G,X,X,X");
    }

    @Test
    public void shouldSolve_Kakuro059() {
        assertKakuro(8172095364L, "7,X,X,X,(vBH),(vBB),X,X,X,X,(hBJ,vBJ),I,O,(vHE),(vI),X,(hBF,vBA),O,O,O,O,O,(hBE),O,D,X,(hA),O,O,(hBC),O,O,(vA),(hBB,vBH),O,O,(hDA),B,H,O,O,O,X,X,X,(hI),O,O,X,X");
    }

    @Test
    public void shouldSolve_Kakuro060() {
        assertKakuro(3067128549L, "7,X,X,X,(vEC),(vD),X,X,X,(vJ),(hEB,vEJ),O,O,X,X,(hFC),O,O,O,F,(vEG),X,(hG),O,O,(hH,vFI),O,E,(vEH),X,(hEB),A,O,(hED,vJ),O,O,X,X,(hFI),O,O,O,O,X,X,(hED),O,O,X,X");
    }

    @Test
    public void shouldSolve_Kakuro061() {
        assertKakuro(7986421035L, "6,X,(vGH),(vGG),X,X,X,(hGE),O,O,(vFI),(vGJ),X,(hGF),O,O,D,O,X,X,(hGB),O,C,O,(vGG),X,(hFG),O,O,O,O,X,X,X,(hE),O,I");
    }

    @Test
    public void shouldSolve_Kakuro062() {
        assertKakuro(7360951248L, "7,X,X,X,(vF),(vGI),X,X,X,(vJ),(hB,vGA),H,G,X,X,(hHF),O,O,O,A,(vHH),X,(hB),O,O,(hGB,vGA),C,O,(vC),X,(hGC),O,O,(hGI,vGF),O,O,X,X,(hHB),O,E,O,O,X,X,(hA),O,O,X,X");
    }

    @Test
    public void shouldSolve_Kakuro063() {
        assertKakuro(3609174825L, "7,X,X,X,X,X,(vED),(vIG),X,X,X,X,(hEC),O,O,X,X,(vAC),(vA),(hH,vEG),O,O,X,(hAE,vB),O,O,H,O,O,(hIJ),O,O,O,B,O,X,(hEC),O,O,X,X,X,X,(hEI),O,O,X,X,X,X");
    }

    @Test
    public void shouldSolve_Kakuro064() {
        assertKakuro(1206439587L, "7,X,X,(vAI),(vAA),X,X,X,X,(hAD,vAG),O,O,(vAE),X,X,(hAH),O,O,O,O,(vBH),(vD),(hG),O,O,(hI,vE),O,O,O,(hAI),O,O,O,(hG,vAC),D,F,X,X,(hAH),O,O,O,O,X,X,X,(hAJ),O,O,X");
    }

    @Test
    public void shouldSolve_Kakuro065() {
        assertKakuro(7408321956L, "7,X,X,(vGD),(vFB),(vJ),X,X,X,(hGD),O,O,O,(vFA),(vGG),X,(hFA),O,O,O,O,O,X,(hGE,vGF),O,O,(hH,vFB),O,O,(hH),O,G,(hGC,vD),O,G,X,(hEB),O,O,O,O,O,X,X,X,(hGC),O,A,O,X");
    }

    @Test
    public void shouldSolve_Kakuro066() {
        assertKakuro(2065187934L, "6,X,X,(vAD),(vEE),X,X,X,(hEC),G,O,(vAJ),(vH),X,(hEC,vEG),O,A,O,O,(hEG),F,O,(hEG,vEG),O,O,(hAB),O,E,F,A,X,X,X,(hEG),O,O,X");
    }

    @Test
    public void shouldSolve_Kakuro067() {
        assertKakuro(8730629514L, "6,X,X,X,X,(vIB),(vJ),X,X,X,(hB,vIJ),O,O,X,X,(hE,vIF),O,O,C,X,(hFC,vIF),O,A,O,X,(hG),O,O,H,X,X,(hIJ),O,O,X,X,X");
    }

    @Test
    public void shouldSolve_Kakuro068() {
        assertKakuro(2067345819L, "6,X,X,X,(vIB),(vEB),X,X,X,(hD,vAE),O,O,(vE),X,(hIJ,vE),O,O,O,O,(hII),O,O,(hJ,vC),H,O,(hAE),O,O,G,J,X,X,(hC),O,O,X,X");
    }

    @Test
    public void shouldSolve_Kakuro069() {
        assertKakuro(8496725031L, "6,X,X,(vFF),(vB),X,X,X,(hC,vI),O,J,(vJE),X,(hJJ),O,O,I,G,(vA),(hJJ),O,O,(hJD,vJE),O,O,X,(hJB),O,O,F,O,X,X,(hJH),C,J,X");
    }

    @Test
    public void shouldSolve_Kakuro070() {
        assertKakuro(7654239801L, "7,X,X,X,(vEI),(vJI),X,X,X,X,(hJA),O,O,(vJE),(vJJ),X,X,(hJI,vJB),O,E,O,D,X,(hJI,vC),O,H,(hJB,vJE),O,O,(hB),O,O,(hF,vD),O,O,X,(hJB),O,O,O,O,X,X,X,X,(hJE),O,O,X,X");
    }

    @Test
    public void shouldSolve_Kakuro071() {
        assertKakuro(5679823401L, "7,X,(vJB),(vFD),X,X,(vFE),(vH),(hJF),O,O,X,(hH),O,O,(hJC),O,O,(vH),(hJF,vJF),O,O,X,(hJI),H,O,O,O,X,X,(hFJ,vJJ),J,O,O,O,(vJA),(hA),G,O,X,(hJF),O,C,(hJC),O,O,X,(hD),O,O");
    }

    @Test
    public void shouldSolve_Kakuro072() {
        assertKakuro(8752403169L, "7,X,(vI),(vDH),X,X,X,X,(hB),O,I,X,X,X,X,(hC),O,O,(vA),(vI),(vDJ),X,(hDH),O,B,O,O,O,(vDH),X,(hGG),O,O,O,J,O,X,X,X,X,(hHH),B,O,X,X,X,X,(hHE),O,O");
    }

    @Test
    public void shouldSolve_Kakuro073() {
        assertKakuro(4961358207L, "6,X,X,(vDI),(vE),X,X,X,(hA,vDA),E,O,(vHI),X,(hHI),F,A,O,O,(vDF),(hDD),O,O,(hDJ,vDJ),O,O,X,(hDG),O,O,H,O,X,X,(hB),O,D,X");
    }

    @Test
    public void shouldSolve_Kakuro074() {
        assertKakuro(6051247938L, "6,X,(vJ),(vDH),X,X,X,(hDA),G,O,(vDA),(vDB),X,(hDB),O,O,I,F,X,X,(hG),O,F,O,(vDI),X,(hED),G,O,O,F,X,X,X,(hDE),O,H");
    }

    @Test
    public void shouldSolve_Kakuro075() {
        assertKakuro(1027635984L, "6,X,X,(vCJ),(vD),X,X,X,(hG),O,O,(vAD),(vAE),X,(hCC,vI),O,O,A,O,(hJ),O,F,(hAD,vAD),I,H,(hCD),O,O,O,F,X,X,X,(hAJ),O,G,X");
    }

    @Test
    public void shouldSolve_Kakuro076() {
        assertKakuro(3564189270L, "7,X,X,X,X,(vEF),(vEC),(vF),X,X,X,(hED,vEB),O,O,O,X,X,(hEB),O,O,O,O,X,X,(hC),O,D,X,X,X,(vI),(hB,vEE),O,O,X,X,(hEB),E,H,D,O,X,X,(hHJ),O,G,O,X,X,X");
    }

    @Test
    public void shouldSolve_Kakuro077() {
        assertKakuro(4893706521L, "7,X,X,X,X,(vJF),(vIC),X,X,X,(vIA),(hD,vJE),O,O,X,X,(hIJ,vD),J,O,O,D,(vG),(hJC),I,O,O,(hJA,vC),O,O,(hJF),J,C,(hJF,vJE),O,O,O,X,(hIB),O,O,O,O,X,X,(hJF),O,O,X,X,X");
    }

    @Test
    public void shouldSolve_Kakuro078() {
        assertKakuro(2746890351L, "6,X,(vH),(vJE),X,X,X,(hC),J,O,(vJJ),(vJC),X,(hJJ),A,I,O,H,X,X,(hD),O,O,A,(vC),X,(hAI),F,B,O,O,X,X,X,(hC),J,O");
    }

    @Test
    public void shouldSolve_Kakuro079() {
        assertKakuro(7259186034L, "7,X,(vA),(vEE),X,X,(vD),(vF),(hEC),O,O,(vIH),(hI,vEB),O,O,(hBD),O,O,O,O,F,O,X,X,(hA),O,O,X,X,X,(vJ),(hEJ,vEG),F,O,(vA),(vG),(hBG),O,O,O,O,O,O,(hEH),O,O,X,(hG),O,O");
    }

    @Test
    public void shouldSolve_Kakuro080() {
        assertKakuro(8295317640L, "6,X,X,X,(vFG),(vFC),X,X,(vE),(hFE,vFF),A,O,X,(hBF),O,O,O,O,(vH),(hE),O,O,(hD,vFF),I,O,X,(hFF),O,O,E,D,X,(hFI),O,O,X,X");
    }

    @Test
    public void shouldSolve_Kakuro081() {
        assertKakuro(742516389L, "6,X,X,(vHA),(vFH),X,X,X,(hFF),O,O,(vFH),(vE),X,(hDI,vFG),O,O,O,O,(hFG),B,O,(hC,vFB),O,O,(hDC),O,G,O,F,X,X,X,(hFF),O,O,X");
    }

    @Test
    public void shouldSolve_Kakuro082() {
        assertKakuro(7134902658L, "7,X,X,(vBE),(vBB),(vA),X,X,X,(hH),O,O,O,(vBA),(vH),X,(hGI,vBB),O,J,O,O,O,(hBG),O,O,X,(hI),O,O,(hC),O,O,(vBG),(hE,vBD),H,C,(hBI),O,O,O,O,O,X,X,X,(hGG),O,O,O,X");
    }

    @Test
    public void shouldSolve_Kakuro083() {
        assertKakuro(8064139257L, "7,X,X,X,X,X,(vHC),(vF),X,X,X,X,(hF,vC),O,E,X,X,(vEJ),(hEF,vEG),F,O,H,X,(hHD),C,O,O,O,X,X,(hHC,vI),A,O,O,O,X,(hJ),D,O,O,X,X,X,(hF),O,O,X,X,X,X");
    }

    @Test
    public void shouldSolve_Kakuro084() {
        assertKakuro(4512607839L, "6,X,X,(vH),(vDC),X,X,X,(hCI,vCD),O,O,X,X,(hH),O,O,O,(vCA),(vCB),(hCJ),O,I,O,D,E,X,X,(hDI),E,H,O,X,X,(hG),O,O,X");
    }

    @Test
    public void shouldSolve_Kakuro085() {
        assertKakuro(4608275139L, "7,X,X,X,X,(vJ),(vHE),X,X,X,X,(hHA,vHF),O,B,(vHE),X,X,(hEC,vHG),O,O,O,O,X,(hHE,vHG),O,O,(hA,vHB),O,O,(hJ),O,O,(hHE,vJ),O,O,X,(hED),O,J,O,O,X,X,X,(hB),O,O,X,X,X");
    }

    @Test
    public void shouldSolve_Kakuro086() {
        assertKakuro(7428590361L, "6,X,X,(vJG),(vA),X,X,X,(hI),B,O,(vJC),(vJH),X,(hJH,vJC),O,E,O,O,(hB),O,O,(hJJ,vF),O,O,(hCE),O,O,D,I,X,X,X,(hB),O,H,X");
    }

    @Test
    public void shouldSolve_Kakuro087() {
        assertKakuro(8742605193L, "6,X,X,X,X,(vDG),(vHH),X,X,(vDH),(hJ,vHB),O,O,X,(hJF),O,O,O,O,X,(hHF,vE),O,O,O,X,(hDJ),H,O,O,I,X,(hHC),G,O,X,X,X");
    }

    @Test
    public void shouldSolve_Kakuro088() {
        assertKakuro(1729458306L, "7,X,(vAI),(vHC),X,X,X,X,(hD),O,G,X,X,(vHI),(vG),(hAJ),O,O,(vB),(hH,vAH),O,O,X,(hHF,vH),O,O,F,O,O,(hCA),O,O,O,O,O,(vF),(hH),O,O,X,(hG),O,O,X,X,X,X,(hAH),O,O");
    }

    @Test
    public void shouldSolve_Kakuro089() {
        assertKakuro(465713928L, "7,X,X,X,X,(vFG),(vFI),X,X,X,X,(hFI,vFB),O,O,(vFJ),X,(vFA),(hFG,vGA),O,B,O,O,(hIB),O,O,O,(hH,vJ),O,O,(hJ),O,O,(hFD,vD),O,C,O,(hII),O,O,O,O,X,X,X,(hE),O,O,X,X,X");
    }

    @Test
    public void shouldSolve_Kakuro090() {
        assertKakuro(6547120893L, "7,X,X,X,(vI),(vEG),(vFD),X,X,(vED),(hA,vEB),O,O,O,X,(hJC),O,O,A,O,O,X,(hEG),O,O,(hEG,vEC),O,O,(vB),X,(hH),O,O,(hJ,vEB),O,O,X,(hEI),O,O,O,O,J,X,(hFF),O,H,O,X,X");
    }

    @Test
    public void shouldSolve_Kakuro091() {
        assertKakuro(2708195346L, "6,X,X,(vEI),(vEB),X,X,X,(hEC,vB),O,O,(vEB),X,(hHC),J,O,O,F,(vEC),(hH),O,O,(hB,vEC),O,O,X,(hEH),O,O,O,O,X,X,(hEA),D,O,X");
    }

    @Test
    public void shouldSolve_Kakuro092() {
        assertKakuro(2105839764L, "6,X,X,(vAF),(vBF),X,X,X,(hBI),O,G,(vAD),(vBD),X,(hBI,vF),O,J,O,E,(hBB),A,G,(hBI,vBI),O,H,(hAJ),B,O,O,O,X,X,X,(hBA),O,O,X");
    }

    @Test
    public void shouldSolve_Kakuro093() {
        assertKakuro(9718204356L, "6,X,(vCB),(vJ),X,X,X,(hCE),A,O,(vCI),X,X,(hCG),D,O,O,(vCC),X,X,(hCA),O,O,O,(vB),X,X,(hB),O,E,G,X,X,X,(hG),O,H");
    }

    @Test
    public void shouldSolve_Kakuro094() {
        assertKakuro(4508327196L, "7,X,X,X,X,X,(vFI),(vHG),X,X,X,X,(hHJ,vHH),O,O,X,X,(vHC),(hHD,vHG),O,O,O,X,(hHH),O,O,O,O,X,X,(hFE,vHC),O,O,O,D,X,(hHE),H,O,O,X,X,X,(hHE),I,A,X,X,X,X");
    }

    @Test
    public void shouldSolve_Kakuro095() {
        assertKakuro(1679823405L, "7,X,X,(vFA),(vC),X,X,X,X,(hE),O,B,(vAC),(vGJ),X,X,(hFF,vG),O,O,O,O,(vAI),(hAA),O,D,(hAB,vAC),O,O,O,(hAH),O,O,O,(hAB,vAB),O,O,X,(hFJ),O,O,O,O,X,X,X,X,(hAH),O,J,X");
    }

    @Test
    public void shouldSolve_Kakuro096() {
        assertKakuro(7485263019L, "7,X,X,X,(vIF),(vIB),X,X,X,X,(hID),O,O,(vC),X,X,(vIF),(hIH,vEE),O,O,O,(vII),(hEB),O,O,O,(hIB,vIF),D,J,(hIF),O,O,(hII,vIE),O,O,O,X,(hJ),O,G,O,X,X,X,X,(hIF),O,O,X,X");
    }

    @Test
    public void shouldSolve_Kakuro097() {
        assertKakuro(8731024596L, "7,X,(vDJ),(vDB),X,X,X,X,(hDJ),O,O,(vDF),(vCE),(vI),X,(hCH),O,O,O,O,O,X,X,X,(hDC,vDB),O,A,G,X,X,(hFE),O,O,O,(vDJ),(vI),X,(hCF),O,O,O,O,O,X,X,X,X,(hDE),O,O");
    }

    @Test
    public void shouldSolve_Kakuro098() {
        assertKakuro(3417205896L, "6,X,X,(vCI),(vJ),X,X,X,(hA),O,E,(vEG),(vCC),X,(hEG,vCF),O,O,D,O,(hJ),C,G,(hB,vCC),C,O,(hED),O,O,A,O,X,X,X,(hCD),O,O,X");
    }

    @Test
    public void shouldSolve_Kakuro099() {
        assertKakuro(5176324890L, "6,X,X,X,(vG),(vFE),X,X,X,(hG,vBC),O,O,(vBC),X,(hFJ,vC),O,E,O,I,(hG),O,O,(hBF,vBC),O,O,(hEJ),O,O,O,O,X,X,(hBA),D,O,X,X");
    }

    @Test
    public void shouldSolve_Kakuro100() {
        assertKakuro(2830915746L, "6,X,X,(vAJ),(vE),X,X,X,(hFH,vH),O,O,(vFA),X,(hFH),O,O,O,O,(vFI),(hI),O,C,(hFI,vFD),O,O,X,(hAC),O,O,I,G,X,X,(hC),O,O,X");
    }

    @Test
    public void shouldSolve_Kakuro101() {
        assertKakuro(9827514360L, "6,X,X,X,(vE),(vCJ),X,X,(vFF),(hA,vHJ),C,O,X,(hFC),O,O,O,F,(vD),(hFI),O,O,(hFE,vFJ),O,O,X,(hFG),O,O,O,O,X,(hFD),O,O,X,X");
    }

    @Test
    public void shouldSolve_Kakuro102() {
        assertKakuro(9120586473L, "7,X,X,X,(vBJ),(vBI),X,X,X,X,(hA),O,O,(vCH),(vBJ),X,(vCJ),(hCB,vG),H,O,I,B,(hBA),O,O,O,(hBE,vG),O,O,(hBB),F,O,(hBE,vBI),O,O,O,(hBI),O,O,O,O,X,X,X,X,(hBC),O,O,X,X");
    }

    @Test
    public void shouldSolve_Kakuro103() {
        assertKakuro(9216837504L, "6,X,X,(vCJ),(vD),X,X,X,(hH),O,O,(vBD),(vJ),X,(hCI,vCH),O,J,F,O,(hCG),O,E,(hA,vCD),O,F,(hBF),O,O,O,O,X,X,X,(hCG),O,O,X");
    }

    @Test
    public void shouldSolve_Kakuro104() {
        assertKakuro(9310564782L, "6,X,X,X,X,(vJB),(vG),X,X,X,(hA,vH),I,O,X,X,(hCD,vCG),O,O,B,X,(hCF,vCD),O,O,O,X,(hJD),O,H,O,X,X,(hB),O,O,X,X,X");
    }

    @Test
    public void shouldSolve_Kakuro105() {
        assertKakuro(1037295846L, "7,X,(vI),(vEH),X,X,(vCC),(vF),(hG),O,O,X,(hH),O,C,(hJ),O,O,(vAD),(hAG,vG),O,O,X,(hEI),F,O,O,O,X,X,(hAD,vAB),O,O,I,O,(vI),(hG),O,O,X,(hC),O,O,(hAJ),O,O,X,(hAA),O,O");
    }

    @Test
    public void shouldSolve_Kakuro106() {
        assertKakuro(9402156378L, "7,X,X,X,X,X,(vEC),(vEA),X,X,X,X,(hB),O,O,X,X,(vDF),(vEH),(hEC,vH),H,O,X,(hEA,vI),O,B,E,O,O,(hDB),E,J,O,D,O,X,(hEH),O,A,X,X,X,X,(hI),O,O,X,X,X,X");
    }

    @Test
    public void shouldSolve_Kakuro107() {
        assertKakuro(9134260875L, "6,X,X,X,(vBC),(vBC),X,X,X,(hBJ,vEC),H,O,(vBB),X,(hBE,vA),D,J,O,O,(hC),O,O,(hBE,vBG),O,O,(hEG),H,O,B,O,X,X,(hBI),O,O,X,X");
    }

    @Test
    public void shouldSolve_Kakuro108() {
        assertKakuro(7528916034L, "7,X,(vE),(vCF),X,X,X,X,(hJ),O,O,(vFB),X,X,X,(hCJ),O,O,A,(vFE),(vCA),X,X,(hIH),O,O,O,O,X,X,(hFF),O,O,O,B,(vFA),X,X,X,(hCI),O,O,O,X,X,X,X,(hFG),O,O");
    }

    @Test
    public void shouldSolve_Kakuro109() {
        assertKakuro(5243680971L, "7,X,X,X,X,(vBH),(vH),X,X,X,X,(hI),O,O,(vE),X,X,X,(hJG,vBF),O,O,O,X,(vH),(hBA,vJE),O,O,O,O,(hDG),O,O,O,O,X,X,(hBG),O,F,O,X,X,X,X,(hA),J,O,X,X,X");
    }

    @Test
    public void shouldSolve_Kakuro110() {
        assertKakuro(3892745016L, "7,X,X,X,X,X,(vIC),(vA),X,X,X,(vII),(hG,vIH),F,I,X,X,(hIG),O,O,O,D,X,X,(hC,vC),O,O,J,X,X,(hIF,vE),O,G,A,X,X,(hIH),O,O,O,O,X,X,(hJ),F,D,X,X,X,X");
    }

    @Test
    public void shouldSolve_Kakuro111() {
        assertKakuro(4017253968L, "7,X,X,X,(vH),(vCJ),X,X,X,(vCG),(hCB,vEG),O,O,X,X,(hEF),O,I,O,O,(vCI),X,(hCD),O,J,(hCB,vCJ),E,O,(vCC),X,(hCE),O,O,(hCI,vH),O,O,X,X,(hEB),O,O,O,O,X,X,(hD),O,O,X,X");
    }

    @Test
    public void shouldSolve_Kakuro112() {
        assertKakuro(263481759L, "6,X,(vGA),(vBE),X,X,X,(hGC),H,O,(vGF),X,X,(hGG),O,O,O,(vGD),X,X,(hBG),O,J,O,(vGD),X,X,(hGD),O,O,E,X,X,X,(hGH),O,O");
    }

    @Test
    public void shouldSolve_Kakuro113() {
        assertKakuro(5392176480L, "6,X,X,(vEE),(vEJ),X,X,X,(hI,vEF),O,O,(vEH),X,(hEA),O,O,O,E,(vB),(hEE),O,O,(hB,vB),O,O,X,(hEG),A,O,I,O,X,X,(hA),D,B,X");
    }

    @Test
    public void shouldSolve_Kakuro114() {
        assertKakuro(8702654193L, "6,X,(vJ),(vHA),X,X,X,(hHH),D,O,(vHG),X,X,(hI),O,O,F,(vDG),X,X,(hDJ),O,O,O,(vHF),X,X,(hHF),O,O,E,X,X,X,(hHE),B,O");
    }

    @Test
    public void shouldSolve_Kakuro115() {
        assertKakuro(8047521936L, "6,X,X,X,X,(vFI),(vE),X,X,X,(hH,vA),J,I,X,X,(hGF,vD),O,O,F,X,(hGF,vC),O,O,A,X,(hD),O,O,O,X,X,(hD),O,O,X,X,X");
    }

    @Test
    public void shouldSolve_Kakuro116() {
        assertKakuro(2546981370L, "7,X,X,(vHG),(vE),X,X,X,X,(hGD),O,O,(vGA),(vHC),(vAJ),X,(hGD,vAC),O,O,O,O,O,(hGC),O,O,(hAA,vGC),O,O,O,(hAC),O,O,F,(hGD,vD),O,O,(hHB),O,O,O,O,O,X,X,X,X,(hI),O,D,X");
    }

    @Test
    public void shouldSolve_Kakuro117() {
        assertKakuro(2135874906L, "7,X,X,(vBG),(vBJ),X,(vBD),(vE),X,(hC),O,O,(hBB,vAG),O,C,X,(hBE),O,O,O,O,D,X,(hBG),O,O,O,(vBE),X,X,(vE),(hBI,vJ),O,O,O,X,(hCG),F,G,O,O,O,X,(hC),O,O,(hBJ),O,O,X");
    }

    @Test
    public void shouldSolve_Kakuro118() {
        assertKakuro(8745239601L, "7,X,X,X,X,X,(vEA),(vJJ),X,X,(vED),(vJI),(hF),O,O,X,(hB),O,O,(hJH,vB),O,O,X,(hED),O,B,O,O,X,X,(hJI,vJI),O,O,C,O,X,(hJH),O,O,(hJJ),O,O,X,(hF),J,E,X,X,X,X");
    }

    @Test
    public void shouldSolve_Kakuro119() {
        assertKakuro(8627143509L, "6,X,(vF),(vED),X,X,X,(hEI),O,O,(vEA),X,X,(hEJ),O,O,J,(vB),X,X,(hB),O,O,O,(vG),X,X,(hJ),B,O,C,X,X,X,(hF),O,E");
    }

    @Test
    public void shouldSolve_Kakuro120() {
        assertKakuro(4615027839L, "6,X,X,X,X,(vCH),(vCD),X,X,X,(hG,vCH),O,O,X,X,(hCH,vCI),O,O,O,X,(hFA,vCE),O,O,J,X,(hFF),O,O,O,X,X,(hI),F,C,X,X,X");
    }

    @Test
    public void shouldSolve_Kakuro121() {
        assertKakuro(3627850149L, "6,X,X,(vCH),(vA),X,X,X,(hE,vE),D,O,(vAG),(vHC),(hHB),O,O,C,O,I,(hHA),O,O,(hE,vJ),O,O,(hCH),A,O,O,O,O,X,X,(hHD),O,O,X");
    }

    @Test
    public void shouldSolve_Kakuro122() {
        assertKakuro(6742981530L, "7,X,(vF),(vDG),(vGD),X,X,X,(hA),O,D,O,(vI),(vGE),X,(hDG),O,C,O,O,O,X,(hGC),H,O,(hH,vA),O,O,(vGF),X,(hH),O,O,(hGB,vGD),O,O,X,(hDH),O,D,O,O,O,X,X,X,(hA),O,O,G");
    }

    @Test
    public void shouldSolve_Kakuro123() {
        assertKakuro(918364725L, "7,X,X,X,X,(vIG),(vIG),X,X,X,X,(hCJ),O,O,(vCE),X,X,X,(hIE,vEA),O,O,O,X,(vJ),(hEA,vIE),O,O,O,O,(hCH),O,F,O,O,X,X,(hCH),I,B,O,X,X,X,X,(hCH),O,O,X,X,X");
    }

    @Test
    public void shouldSolve_Kakuro124() {
        assertKakuro(6801295347L, "7,X,X,X,X,(vJ),(vDB),X,X,X,X,(hDG,vH),O,O,X,X,(vB),(hJ,vEB),E,O,O,(vG),(hDJ),O,F,D,(hI,vDC),O,O,(hA),O,O,(hJ,vA),O,O,I,X,(hDA),O,O,O,X,X,X,(hDH),O,O,X,X,X");
    }

    @Test
    public void shouldSolve_Kakuro125() {
        assertKakuro(489165723L, "6,X,X,X,(vEE),(vJA),(vEI),X,X,(hD,vEE),O,F,O,X,(hED,vEC),O,O,O,O,(hJ),O,O,(hEH,vEI),O,O,(hIB),O,O,O,O,X,(hII),O,O,O,X,X");
    }

    @Test
    public void shouldSolve_Kakuro126() {
        assertKakuro(7396412058L, "6,X,(vE),(vGH),X,X,X,(hC),O,J,(vFJ),X,X,(hGH),O,O,O,(vJ),X,X,(hFA),B,O,I,(vFF),X,X,(hFG),O,O,O,X,X,X,(hB),F,G");
    }

    @Test
    public void shouldSolve_Kakuro127() {
        assertKakuro(5274930816L, "6,X,X,(vIF),(vIJ),X,X,X,(hD,vIC),O,O,X,X,(hIB),O,O,O,(vIG),(vA),(hBF),O,O,F,I,O,X,X,(hE),D,O,F,X,X,(hIF),O,C,X");
    }

    @Test
    public void shouldSolve_Kakuro128() {
        assertKakuro(9724086513L, "7,X,(vCD),(vB),X,X,X,X,(hII),O,D,(vA),X,X,X,(hIJ),O,O,O,(vII),X,X,(hID),O,O,O,O,(vIJ),(vCJ),X,X,(hCA),H,O,F,O,X,X,X,(hA),O,O,G,X,X,X,X,(hII),J,O");
    }

    @Test
    public void shouldSolve_Kakuro129() {
        assertKakuro(8697014235L, "7,X,(vC),(vFF),X,X,(vHF),(vD),(hFD),O,O,(vHG),(hA,vFJ),O,O,(hHF),O,O,O,O,O,O,X,X,(hFG,vFH),O,O,O,X,X,(hFB,vI),O,O,O,(vFB),(vB),(hIG),O,O,O,O,D,J,(hG),O,I,X,(hFE),O,O");
    }

    @Test
    public void shouldSolve_Kakuro130() {
        assertKakuro(7862450193L, "7,X,(vHJ),(vDE),X,X,(vDI),(vHH),(hHG),O,J,(vHJ),(hJ),O,O,(hHE),O,O,O,(hHJ,vB),O,O,X,(hHH),O,O,O,O,X,X,(hDJ,vHA),D,O,E,O,(vF),(hHJ),O,O,(hA),O,O,E,(hHA),O,O,X,(hI),O,O");
    }

    @Test
    public void shouldSolve_Kakuro131() {
        assertKakuro(4680125739L, "7,X,(vEH),(vFA),X,X,X,X,(hEB),O,O,(vFA),X,X,X,(hFD),O,O,O,(vEE),(vID),X,X,(hFB),O,O,O,O,X,X,(hFJ),O,O,O,O,(vEE),X,X,X,(hJ),O,B,O,X,X,X,X,(hEH),C,O");
    }

    @Test
    public void shouldSolve_Kakuro132() {
        assertKakuro(4318605279L, "6,X,(vJ),(vE),X,X,X,(hA),B,C,(vCJ),X,X,(hCG),O,O,O,(vCD),X,X,(hHF),O,O,O,(vJ),X,X,(hE),O,O,H,X,X,X,(hCE),O,O");
    }

    @Test
    public void shouldSolve_Kakuro133() {
        assertKakuro(8076951324L, "6,X,(vGC),(vGH),X,X,X,(hGG),O,O,(vGB),X,X,(hGI),E,O,I,(vGG),X,X,(hIJ),O,C,O,(vA),X,X,(hD),G,O,O,X,X,X,(hD),O,O");
    }

    @Test
    public void shouldSolve_Kakuro134() {
        assertKakuro(6789302514L, "6,X,X,X,X,(vIG),(vII),X,X,X,(hE,vIA),I,G,X,X,(hGJ,vGF),O,C,O,X,(hIE,vII),D,O,O,X,(hGJ),O,B,O,X,X,(hA),O,J,X,X,X");
    }

    @Test
    public void shouldSolve_Kakuro135() {
        assertKakuro(358946712L, "6,X,X,X,X,(vIA),(vE),X,X,(vJB),(hB,vII),I,J,X,(hIF),O,O,O,H,X,(hIB,vG),D,J,O,X,(hJG),C,O,O,F,X,(hB),O,O,X,X,X");
    }

    @Test
    public void shouldSolve_Kakuro136() {
        assertKakuro(3492051678L, "7,X,X,X,(vDB),(vGG),X,X,X,X,(hGH),O,O,(vGA),(vGA),X,X,(hGF,vGA),O,O,O,O,X,(hGA,vGE),B,O,(hGD,vI),O,O,(hJ),O,I,(hGE,vGG),O,O,X,(hDA),O,D,O,O,X,X,X,X,(hF),O,O,X,X");
    }

    @Test
    public void shouldSolve_Kakuro137() {
        assertKakuro(7594021368L, "6,X,X,X,(vFB),(vI),X,X,X,(hGF),O,O,(vGA),X,(vH),(hGA,vFD),O,O,O,(hFF),O,A,O,O,C,(hGG),O,J,O,X,X,X,(hGH),O,D,X,X");
    }

    @Test
    public void shouldSolve_Kakuro138() {
        assertKakuro(9370451286L, "6,X,X,(vGA),(vA),X,X,X,(hB,vGE),O,O,(vHJ),X,(hBD),O,O,O,O,(vGH),(hGC),O,O,(hGJ,vGE),O,O,X,(hGG),O,F,O,O,X,X,(hGC),O,O,X");
    }

    @Test
    public void shouldSolve_Kakuro139() {
        assertKakuro(8923176045L, "7,X,X,(vCE),(vG),(vI),X,X,X,(hEE),A,O,E,(vCD),(vCH),X,(hEG,vCD),O,O,O,O,O,(hA),G,C,X,(hEH),O,O,(hEE),O,O,(vI),(hA,vD),O,O,(hCF),O,O,O,O,O,X,X,X,(hED),O,O,B,X");
    }

    @Test
    public void shouldSolve_Kakuro140() {
        assertKakuro(2351846907L, "7,X,(vG),(vDC),X,(vBA),(vDG),X,(hJ),O,G,(hDA,vBA),O,O,X,(hBC),O,O,G,O,O,X,X,(hDH),O,O,O,(vG),X,X,X,(hG,vDI),O,O,O,(vJ),X,(hBB),E,O,O,O,O,X,(hH),O,J,(hB),O,O");
    }

    @Test
    public void shouldSolve_Kakuro141() {
        assertKakuro(8734650921L, "6,X,X,X,(vJG),(vCG),X,X,(vJG),(hJB,vJH),O,O,X,(hJH),I,B,O,O,(vD),(hJB),O,O,(hA,vJG),O,O,X,(hJB),O,B,O,O,X,(hF),I,C,X,X");
    }

    @Test
    public void shouldSolve_Kakuro142() {
        assertKakuro(9604572831L, "7,X,(vA),(vE),X,X,(vD),(vB),(hF),O,O,(vJJ),(hI,vGD),O,O,(hGD),O,O,O,O,I,O,X,X,(hJI),O,O,X,X,X,(vJE),(hA,vF),I,O,(vD),(vJJ),(hGA),O,O,O,J,O,O,(hH),O,O,X,(hI),O,O");
    }

    @Test
    public void shouldSolve_Kakuro143() {
        assertKakuro(5489106327L, "7,X,X,(vEH),(vEF),X,X,X,X,(hEI,vIH),O,O,(vEI),X,X,(hEI),O,O,O,O,(vIE),(vEJ),(hD),O,O,(hEH,vH),O,O,O,(hEC),O,O,O,(hD,vC),H,G,X,X,(hIA),O,O,O,O,X,X,X,(hD),E,O,X");
    }

    @Test
    public void shouldSolve_Kakuro144() {
        assertKakuro(4813265097L, "7,X,X,X,X,X,(vEA),(vCJ),X,X,X,X,(hCD,vCC),O,O,X,X,(vCI),(hCJ,vEH),O,O,O,X,(hDH),O,J,B,O,X,X,(hCH,vD),O,O,O,O,X,(hCJ),O,O,O,X,X,X,(hJ),O,G,X,X,X,X");
    }

    @Test
    public void shouldSolve_Kakuro145() {
        assertKakuro(458316729L, "7,X,(vB),(vFF),X,(vEI),(vFE),X,(hH),O,O,(hFC,vIB),G,O,X,(hFC),O,O,O,O,O,X,X,X,(hFH),O,D,X,X,X,X,(hFF,vFG),O,O,(vFE),(vFH),X,(hEE),O,O,J,O,O,X,(hFG),O,O,(hFG),O,O");
    }

    @Test
    public void shouldSolve_Kakuro146() {
        assertKakuro(734659128L, "6,X,(vHE),(vII),X,X,X,(hHB),O,O,(vHF),(vHJ),X,(hHD),B,O,O,O,X,X,(hG),H,O,O,(vHE),X,(hCA),O,O,E,B,X,X,X,(hHB),O,G");
    }

    @Test
    public void shouldSolve_Kakuro147() {
        assertKakuro(1402985736L, "6,X,(vH),(vAF),X,X,X,(hAC),O,O,(vAD),X,X,(hDI),J,O,O,(vAH),X,X,(hAC),O,O,O,(vAI),X,X,(hH),O,O,B,X,X,X,(hAH),O,E");
    }

    @Test
    public void shouldSolve_Kakuro148() {
        assertKakuro(847295163L, "6,X,(vC),(vHA),X,X,X,(hC),O,J,(vHA),X,X,(hF),J,O,O,(vHC),X,X,(hI),O,J,O,(vF),X,X,(hEJ),O,O,B,X,X,X,(hG),O,O");
    }

    @Test
    public void shouldSolve_Kakuro149() {
        assertKakuro(3874510962L, "6,X,X,X,(vFJ),(vJC),X,X,(vFF),(hFF,vJE),O,O,X,(hFH),O,F,O,O,(vD),(hFI),O,C,(hE,vH),D,O,X,(hJC),O,O,O,A,X,(hFG),O,J,X,X");
    }

    @Test
    public void shouldSolve_Kakuro150() {
        assertKakuro(8192375460L, "7,X,X,X,X,X,(vDE),(vBB),X,(vC),(vDF),X,(hBF),O,O,(hH),O,O,(vE),(hH,vBI),B,O,(hDF),O,O,O,O,D,(vE),X,(hDI,vBE),O,O,C,O,B,(hBF),O,A,X,(hG),E,D,(hG),O,O,X,X,X,X");
    }

    @Test
    public void shouldSolve_Kakuro151() {
        assertKakuro(8065932174L, "7,X,(vJ),(vFH),X,X,X,X,(hHH),F,A,X,X,(vGE),(vA),(hI),O,O,(vC),(hF,vD),O,O,X,(hHC,vF),H,O,O,O,O,(hGJ),O,O,O,O,O,(vE),(hE),O,O,X,(hHI),O,O,X,X,X,X,(hA),O,O");
    }

    @Test
    public void shouldSolve_Kakuro152() {
        assertKakuro(5219036478L, "7,X,X,(vCD),(vCB),(vF),X,X,X,(hCA,vCJ),O,O,O,(vFH),X,(hCD),O,O,O,O,O,(vCB),(hH),O,O,X,(hI),O,O,(hCE),O,B,(vCE),(hCH,vCI),O,G,X,(hFA),O,G,O,O,O,X,X,(hBC),H,O,O,X");
    }

    @Test
    public void shouldSolve_Kakuro153() {
        assertKakuro(3865904127L, "6,X,X,X,X,(vHD),(vHH),X,X,X,(hA,vHH),H,I,X,X,(hHJ,vIG),O,C,O,X,(hHC,vE),O,O,O,X,(hIG),J,O,O,X,X,(hHF),O,O,X,X,X");
    }

    @Test
    public void shouldSolve_Kakuro154() {
        assertKakuro(4670925831L, "6,X,X,(vFD),(vJB),X,X,X,(hH,vH),O,O,(vJD),X,(hFH),O,O,O,O,(vJI),(hJD),O,O,(hJD,vG),J,E,X,(hJD),O,O,O,O,X,X,(hB),A,O,X");
    }

    @Test
    public void shouldSolve_Kakuro155() {
        assertKakuro(592378164L, "6,X,X,X,(vC),(vDC),X,X,(vF),(hHB,vDI),O,O,(vDJ),(hDG),O,O,E,O,O,(hHA),O,O,(hHD,vG),O,O,(hEJ),O,O,F,O,O,X,(hJ),O,O,X,X");
    }

    @Test
    public void shouldSolve_Kakuro156() {
        assertKakuro(945213768L, "7,X,X,X,X,X,(vEJ),(vG),X,X,X,X,(hD,vI),C,O,X,X,(vEG),(hFE,vFE),O,O,O,X,(hFD),O,O,O,O,X,X,(hEC,vFI),O,O,O,O,X,(hEC),B,O,H,X,X,X,(hJ),O,O,X,X,X,X");
    }

    @Test
    public void shouldSolve_Kakuro157() {
        assertKakuro(2416907835L, "7,X,(vI),(vAC),X,X,(vAI),(vCG),(hB),O,I,X,(hCB,vCD),O,O,(hH),A,D,(hCD,vAF),O,O,O,X,(hAC),O,O,O,O,X,X,(hCF,vCC),O,O,O,O,(vB),(hCB),O,O,O,(hCF),O,O,(hCB),O,J,X,(hB),O,O");
    }

    @Test
    public void shouldSolve_Kakuro158() {
        assertKakuro(8765340921L, "6,X,X,X,(vJB),(vIG),X,X,(vA),(hJI,vJC),O,F,X,(hJB),O,O,O,O,(vJE),(hJD),B,O,(hJB,vD),O,H,X,(hJG),O,I,O,O,X,(hA),O,E,X,X");
    }

    @Test
    public void shouldSolve_Kakuro159() {
        assertKakuro(4617392085L, "7,X,X,X,X,(vCD),(vCC),(vB),X,X,X,(hCC,vEC),O,I,O,X,X,(hCH),C,O,O,O,X,X,(hCA),F,O,X,X,X,(vA),(hCH,vCE),O,E,X,X,(hGA),C,O,O,O,X,X,(hCE),O,O,O,X,X,X");
    }

    @Test
    public void shouldSolve_Kakuro160() {
        assertKakuro(8972436051L, "6,X,X,X,X,(vJI),(vA),X,X,(vJH),(hJE,vJI),O,G,X,(hJE),F,O,O,D,X,(hC,vB),O,E,O,X,(hJH),O,O,O,O,X,(hJD),O,E,X,X,X");
    }

    @Test
    public void shouldSolve_Kakuro161() {
        assertKakuro(1406852937L, "6,X,X,X,X,(vAJ),(vAJ),X,X,X,(hAF,vGB),O,O,X,X,(hAE,vD),O,O,O,X,(hAJ,vF),O,J,O,X,(hAF),O,O,H,X,X,(hB),O,I,X,X,X");
    }

    @Test
    public void shouldSolve_Kakuro162() {
        assertKakuro(4926578310L, "7,X,X,X,X,(vH),(vIE),X,X,X,X,(hA,vA),O,O,X,X,(vID),(hF,vCH),O,O,A,(vIE),(hIH),O,O,O,(hIA,vIH),O,O,(hIE),O,O,(hIG,vIA),B,O,O,X,(hIF),O,G,A,X,X,X,(hIE),O,D,X,X,X");
    }

    @Test
    public void shouldSolve_Kakuro163() {
        assertKakuro(8395120674L, "7,X,(vEF),(vB),(vFC),X,X,X,(hH),O,O,O,(vEA),X,X,(hED),C,O,O,O,X,X,X,X,(hEG),O,F,X,X,X,X,(hEI),O,O,(vEH),(vI),X,X,(hFH),O,O,O,O,X,X,X,(hEE),O,I,O");
    }

    @Test
    public void shouldSolve_Kakuro164() {
        assertKakuro(3572684109L, "6,X,(vHI),(vDG),X,X,X,(hHE),J,O,(vDG),X,X,(hHC),H,O,O,(vHA),X,X,(hDH),F,O,G,(vHE),X,X,(hHC),O,O,O,X,X,X,(hHE),O,O");
    }

    @Test
    public void shouldSolve_Kakuro165() {
        assertKakuro(1832790564L, "6,X,X,(vAD),(vAE),X,X,X,(hAA),O,O,(vAD),(vAA),X,(hAI,vI),O,F,D,J,(hC),A,O,(hB,vJ),A,E,(hAB),O,I,C,J,X,X,X,(hI),O,H,X");
    }

    @Test
    public void shouldSolve_Kakuro166() {
        assertKakuro(891742635L, "6,X,X,(vDA),(vE),X,X,X,(hJ,vDE),O,F,(vGG),X,(hDJ),O,O,O,O,(vC),(hDD),O,O,(hJ,vI),O,O,X,(hGG),O,D,O,O,X,X,(hDA),G,B,X");
    }

    @Test
    public void shouldSolve_Kakuro167() {
        assertKakuro(8560127493L, "7,X,X,(vJD),(vG),(vI),X,X,X,(hG),O,O,H,(vEB),(vEF),X,(hEB),O,O,B,O,J,X,(hEJ,vA),O,H,(hEE,vEA),O,O,(hA),O,O,(hEJ,vG),O,O,X,(hJF),O,O,O,O,O,X,X,X,(hG),F,O,O,X");
    }

    @Test
    public void shouldSolve_Kakuro168() {
        assertKakuro(7891265430L, "6,X,X,X,X,(vEJ),(vG),X,X,X,(hDE,vF),O,O,X,X,(hDJ,vF),O,O,O,X,(hA,vDA),O,O,O,X,(hDI),B,O,O,X,X,(hDE),C,O,X,X,X");
    }

    @Test
    public void shouldSolve_Kakuro169() {
        assertKakuro(3207154968L, "6,X,X,(vAC),(vD),X,X,X,(hD,vEI),O,O,(vBC),X,(hBA),O,O,O,O,(vH),(hEF),O,O,(hEI,vF),O,O,X,(hEF),O,O,A,O,X,X,(hEE),G,D,X");
    }

    @Test
    public void shouldSolve_Kakuro170() {
        assertKakuro(4079361285L, "6,X,X,(vGB),(vD),X,X,X,(hGG),A,C,(vGJ),(vC),X,(hGG,vGC),O,O,O,J,(hGH),O,O,(hE,vI),G,H,(hHF),O,H,O,O,X,X,X,(hE),O,O,X");
    }

    @Test
    public void shouldSolve_Kakuro171() {
        assertKakuro(9317086524L, "6,X,X,(vIJ),(vCD),X,X,X,(hCD),O,O,(vCI),(vCG),X,(hIH,vCC),G,O,O,O,(hCE),O,I,(hCH,vCD),G,O,(hIC),B,D,O,O,X,X,X,(hA),O,O,X");
    }

    @Test
    public void shouldSolve_Kakuro172() {
        assertKakuro(3782590416L, "7,X,(vII),(vDH),(vID),X,X,X,(hIG),O,O,O,X,X,X,(hDA),O,C,J,(vII),X,X,X,(hID),F,O,O,(vDH),X,X,X,(hID),O,O,O,(vID),X,X,X,(hIE),A,O,O,X,X,X,(hDD),O,O,O");
    }

    @Test
    public void shouldSolve_Kakuro173() {
        assertKakuro(3657194820L, "7,X,(vEB),(vF),X,X,X,X,(hED),O,O,(vAJ),(vED),(vD),X,(hIB),O,O,O,G,O,X,X,X,(hF,vA),O,O,O,X,X,(hED),O,O,F,(vA),(vEB),X,(hIE),O,H,O,O,O,X,X,X,X,(hEE),O,O");
    }

    @Test
    public void shouldSolve_Kakuro174() {
        assertKakuro(5917680432L, "7,X,X,X,X,(vCA),(vCE),(vB),X,X,X,(hF),O,O,O,X,X,X,(hJG,vCD),I,O,O,X,X,(hF,vB),O,O,O,X,X,(hJI,vCI),O,F,O,X,X,(hD),O,O,O,X,X,X,(hCI),O,O,O,X,X,X");
    }

    @Test
    public void shouldSolve_Kakuro175() {
        assertKakuro(2037594861L, "6,X,(vJI),(vI),X,X,X,(hH),O,O,(vD),X,X,(hJA),F,O,O,(vJH),X,X,(hJI),C,G,O,(vJJ),X,X,(hD),O,O,O,X,X,X,(hJE),O,O");
    }

    @Test
    public void shouldSolve_Kakuro176() {
        assertKakuro(2851034796L, "6,X,X,X,(vDC),(vAE),X,X,X,(hI),O,B,(vI),X,(vC),(hJ,vDE),O,O,O,(hAF),A,D,O,O,O,(hI),O,O,G,X,X,X,(hDA),H,O,X,X");
    }

    @Test
    public void shouldSolve_Kakuro177() {
        assertKakuro(2695418307L, "7,X,X,X,(vFD),(vAF),X,X,X,(vFD),(hFE,vFA),B,O,X,X,(hHI),O,O,O,O,(vFF),X,(hFI),O,O,(hC,vG),O,H,(vFA),X,(hE),O,O,(hFB,vC),O,O,X,X,(hFJ),O,G,O,O,X,X,(hH),O,O,X,X");
    }

    @Test
    public void shouldSolve_Kakuro178() {
        assertKakuro(4053987261L, "7,X,X,X,X,(vD),(vHD),X,X,X,(vDH),(hA,vJJ),O,O,(vE),X,(hHB,vJH),O,O,O,E,J,(hJE),H,O,O,(hD,vF),O,O,(hJG),E,O,(hJE,vJG),C,O,O,(hHH),J,O,O,O,O,X,X,(hJJ),O,O,X,X,X");
    }

    @Test
    public void shouldSolve_Kakuro179() {
        assertKakuro(7195206834L, "7,X,X,X,X,(vBA),(vEB),X,X,X,(vBG),(hC,vBB),O,O,X,X,(hBD,vBA),O,O,O,O,(vBJ),(hBC),O,O,O,(hBG,vBD),A,O,(hBB),O,O,(hEE,vBF),O,O,D,X,(hBJ),O,O,O,I,X,X,(hBD),O,O,X,X,X");
    }

    @Test
    public void shouldSolve_Kakuro180() {
        assertKakuro(8541329706L, "7,X,X,X,X,X,(vDG),(vC),X,(vB),(vFH),X,(hC),E,O,(hA),O,O,(vDD),(hH,vDB),O,O,(hDA),C,O,O,O,O,(vE),X,(hFH,vDE),O,O,H,O,F,(hDH),O,O,X,(hDI),O,O,(hJ),O,O,X,X,X,X");
    }

    @Test
    public void shouldSolve_Kakuro181() {
        assertKakuro(6531904827L, "6,X,(vB),(vE),X,X,X,(hA),D,O,(vA),X,X,(hH),O,C,O,(vIG),X,X,(hDI),O,O,O,(vDF),X,X,(hIF),O,O,O,X,X,X,(hH),O,O");
    }

    @Test
    public void shouldSolve_Kakuro182() {
        assertKakuro(7236908154L, "7,X,(vHF),(vC),X,X,(vC),(vHF),(hC),O,O,(vBC),(hA,vBF),O,O,(hBE),O,O,O,O,O,O,X,X,(hHD),A,O,X,X,X,(vD),(hJ,vHA),O,O,(vHI),(vC),(hCH),J,O,O,O,O,B,(hHH),O,O,X,(hE),O,O");
    }

    @Test
    public void shouldSolve_Kakuro183() {
        assertKakuro(381524796L, "6,X,X,X,(vJ),(vDA),X,X,(vFD),(hB,vFE),O,O,(vDA),(hDJ),O,O,O,O,O,(hDE),O,O,(hDA,vC),O,H,(hBA),O,I,O,G,O,X,(hJ),E,O,X,X");
    }

    @Test
    public void shouldSolve_Kakuro184() {
        assertKakuro(7364291850L, "6,X,(vGA),(vA),X,X,X,(hGE),O,O,(vGD),X,X,(hGA),O,G,A,(vED),X,X,(hGE),O,O,O,(vGD),X,X,(hEB),C,H,F,X,X,X,(hGE),A,I");
    }

    @Test
    public void shouldSolve_Kakuro185() {
        assertKakuro(6374925810L, "6,X,(vIC),(vFD),X,X,X,(hIG),O,C,(vIB),X,X,(hFJ),O,O,O,(vII),X,X,(hIE),O,O,F,(vIA),X,X,(hIJ),F,I,O,X,X,X,(hIC),O,O");
    }

    @Test
    public void shouldSolve_Kakuro186() {
        assertKakuro(564738192L, "6,X,X,X,(vJG),(vHH),X,X,X,(hHA),O,O,(vHD),X,(vE),(hJF,vHJ),O,O,O,(hHB),F,O,D,O,O,(hE),O,J,O,X,X,X,(hHE),I,O,X,X");
    }

    @Test
    public void shouldSolve_Kakuro187() {
        assertKakuro(8245361097L, "7,X,X,X,(vGG),(vI),(vEC),X,X,(vBH),(hJ,vBI),O,O,O,X,(hBJ),O,O,O,O,O,(vJ),(hGJ),O,O,X,(hA),O,O,(hGC),O,O,(vC),(hGB,vGJ),O,O,X,(hBF),O,O,O,O,B,X,(hBH),O,O,O,X,X");
    }

    @Test
    public void shouldSolve_Kakuro188() {
        assertKakuro(2704639158L, "7,X,X,X,X,X,(vD),(vHB),X,X,(vG),(vFC),(hHA,vAI),O,O,X,(hAB),O,O,O,O,O,X,(hAD),O,O,O,(vHB),X,X,(vF),(hAF,vHI),O,O,O,X,(hAB),O,O,O,O,O,X,(hB),O,E,X,X,X,X");
    }

    @Test
    public void shouldSolve_Kakuro189() {
        assertKakuro(172543698L, "6,X,(vBC),(vDF),X,X,X,(hBE),O,O,(vDB),X,X,(hDG),O,J,O,(vC),X,X,(hBI),O,O,O,(vBB),X,X,(hBA),O,O,D,X,X,X,(hBG),F,O");
    }

    @Test
    public void shouldSolve_Kakuro190() {
        assertKakuro(9603471528L, "6,X,X,X,(vH),(vDC),(vGA),X,X,(hA,vIE),O,O,O,X,(hIG,vGG),O,O,O,O,(hF),O,O,(hGF,vJ),J,O,(hGA),O,O,O,O,X,(hIE),O,O,O,X,X");
    }

    @Test
    public void shouldSolve_Kakuro191() {
        assertKakuro(8976035124L, "6,X,(vHC),(vHJ),X,X,X,(hHC),A,B,(vA),X,X,(hHI),O,O,O,(vHA),X,X,(hD),F,O,O,(vB),X,X,(hII),G,O,O,X,X,X,(hB),O,O");
    }

    @Test
    public void shouldSolve_Kakuro192() {
        assertKakuro(5863470921L, "7,X,(vH),(vJA),X,X,(vIE),(vJI),(hJC),O,O,(vDG),(hJE,vIG),O,O,(hDD),I,O,O,O,O,O,X,X,(hII,vIG),O,O,O,X,X,(hIE,vJA),O,O,O,(vB),(vJI),(hDG),C,O,O,O,O,O,(hJF),O,O,X,(hH),O,O");
    }

    @Test
    public void shouldSolve_Kakuro193() {
        assertKakuro(295368174L, "7,X,(vHH),(vBE),X,X,X,X,(hE),B,O,X,(vHF),(vBJ),X,(hHI),C,O,(hJ,vHI),O,O,X,X,(hBC),D,O,O,O,X,X,(hHH),O,O,D,O,(vHF),X,(hHD),F,O,(hHD),G,O,X,X,X,X,(hHE),O,O");
    }

    @Test
    public void shouldSolve_Kakuro194() {
        assertKakuro(4765201938L, "7,X,X,X,X,X,(vIF),(vI),X,X,X,X,(hB,vGF),O,O,X,X,(vEG),(hGG,vB),O,O,O,X,(hGJ),O,O,O,H,X,X,(hGA,vA),O,O,O,O,X,(hGC),I,H,O,X,X,X,(hH),G,J,X,X,X,X");
    }

    @Test
    public void shouldSolve_Kakuro195() {
        assertKakuro(8267490531L, "7,X,X,X,X,X,(vJF),(vJF),X,X,X,X,(hJD),A,O,X,X,(vBG),(vJB),(hI,vI),O,O,X,(hBD,vJF),F,O,O,E,O,(hIB),O,O,O,O,C,X,(hJG),O,B,X,X,X,X,(hI),O,J,X,X,X,X");
    }

    @Test
    public void shouldSolve_Kakuro196() {
        assertKakuro(8294361705L, "6,X,X,(vEI),(vC),X,X,X,(hH,vGG),O,O,(vGD),X,(hBJ),O,O,O,O,(vD),(hGI),O,O,(hD,vD),E,G,X,(hBG),O,O,A,O,X,X,(hJ),O,O,X");
    }

    @Test
    public void shouldSolve_Kakuro197() {
        assertKakuro(9865237401L, "7,X,X,X,X,(vFI),(vJF),X,X,X,X,(hJH),O,O,(vJC),X,X,X,(hEE,vEC),O,O,O,X,(vJE),(hED,vEF),O,O,O,G,(hJB),O,O,O,O,X,X,(hEH),O,O,G,X,X,X,X,(hJG),O,O,X,X,X");
    }

    @Test
    public void shouldSolve_Kakuro198() {
        assertKakuro(6350149287L, "7,X,X,X,(vJ),(vEI),X,X,X,X,(hJ,vEC),O,A,(vBD),X,X,(hHC,vEA),O,O,O,I,(vF),(hEE),O,O,(hEE,vHD),B,J,O,(hHE),O,O,O,(hG,vED),O,O,X,(hHD),O,O,O,O,X,X,X,(hEA),O,O,X,X");
    }

    @Test
    public void shouldSolve_Kakuro199() {
        assertKakuro(3065127948L, "7,X,X,X,X,X,(vFH),(vED),X,X,X,X,(hEC,vEA),O,O,X,X,(vED),(hFI,vEH),O,O,O,X,(hEE),O,O,A,D,X,X,(hFB,vJ),O,O,O,J,X,(hFI),O,O,O,X,X,X,(hI),O,A,X,X,X,X");
    }

    @Test
    public void shouldSolve_Kakuro200() {
        assertKakuro(9473082156L, "6,X,(vB),(vHI),X,X,X,(hHH),O,O,(vHJ),(vGA),X,(hHH),O,O,O,I,X,X,(hGE),O,A,O,(vHE),X,(hHJ),H,B,F,D,X,X,X,(hHJ),O,C");
    }
	private static void assertKakuro(long exp, String kakuro) {
		assertEquals(exp, solveKakuro(kakuro));
	}

}
