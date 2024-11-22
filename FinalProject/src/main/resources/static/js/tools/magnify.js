let magnifyEnabled = false;

function enableMagnify() {
    const dicomElement = document.getElementById('image-viewer');
    
    if (!cornerstone.getEnabledElement(dicomElement)) {
        cornerstone.enable(dicomElement);
        console.log("DICOM Viewer 활성화 완료");
    }

    deactivateAllTools(dicomElement);
    magnifyEnabled = !magnifyEnabled;

    if (magnifyEnabled) {
        const magnifySize = 200; // 렌즈 크기 증가
        const magnificationLevel = 3; // 확대 배율 증가

        cornerstoneTools.addTool(cornerstoneTools.MagnifyTool, {
            configuration: {
                magnifySize,
                magnificationLevel,
            }
        });

        cornerstoneTools.setToolActiveForElement(dicomElement, 'Magnify', { mouseButtonMask: 1 });
        document.getElementById('magnify').classList.add('active');
        
        dicomElement.addEventListener('mousemove', (event) => moveMagnify(event, dicomElement, magnifySize));
        console.log("도구 'Magnify' 활성화됨");
    } else {
        cornerstoneTools.setToolDisabledForElement(dicomElement, 'Magnify');
        document.getElementById('magnify').classList.remove('active');
        
        dicomElement.removeEventListener('mousemove', moveMagnify);
        console.log("도구 'Magnify' 상태 비활성화됨");
    }
}

function moveMagnify(event, dicomElement, magnifySize) {
    const boundingRect = dicomElement.getBoundingClientRect();
    const mouseX = event.clientX - boundingRect.left;
    const mouseY = event.clientY - boundingRect.top;

    cornerstoneTools.setToolState(dicomElement, 'magnify', {
        center: { x: mouseX, y: mouseY },
        magnifySize,
    });

    cornerstone.updateImage(dicomElement);
}
