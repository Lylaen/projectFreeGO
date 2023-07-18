/* document.addEventListener("DOMContentLoaded", function(event) {
	var elementi = document.querySelectorAll(".animate__animated"); // Seleziona tutti gli elementi con la classe animate__animated
	var delay = 0; // Ritardo iniziale tra le animazioni (in millisecondi)
	var interval = 400; // Intervallo tra le animazioni successive (in millisecondi)

	elementi.forEach(function(elemento) {
	  setTimeout(function() {
		elemento.classList.add("animate__slideInUp"); // Aggiungi la classe di animazione
	  }, delay);
	  
	  delay += interval; // Incrementa il ritardo per l'animazione successiva
	});
  }); */


function enableDisableCheckboxesm1() {
	const checkboxes = document.querySelectorAll('#modalIntolleranze input[type="checkbox"]');
	const maxSelections = 2;

	checkboxes.forEach((checkbox) => {
		checkbox.addEventListener('change', function() {
			const selectedCheckboxes = document.querySelectorAll('#modalIntolleranze input[type="checkbox"]:checked');

			if (selectedCheckboxes.length >= maxSelections) {
				checkboxes.forEach((cb) => {
					if (!cb.checked) {
						cb.disabled = true;
					}
				});
			} else {
				checkboxes.forEach((cb) => {
					cb.disabled = false;
				});
			}
		});
	});
}

enableDisableCheckboxesm1();

function enableDisableCheckboxm2() {
	const checkboxes = document.querySelectorAll('#modalTempo input[type="checkbox"]');

	checkboxes.forEach((checkbox) => {
		checkbox.addEventListener('change', function() {
			checkboxes.forEach((cb) => {
				if (cb !== checkbox) {
					cb.disabled = checkbox.checked;
				}
			});
		});
	});
}

enableDisableCheckboxm2();




document.addEventListener("DOMContentLoaded", function() {
	window.addEventListener("scroll", revealSections);
});

function revealSections() {
	var sections = document.getElementsByClassName("section");

	for (var i = 0; i < sections.length; i++) {
		var section = sections[i];
		var sectionPosition = section.getBoundingClientRect().top;
		var screenHeight = window.innerHeight;

		if (sectionPosition < screenHeight) {
			section.classList.add("visible");
		}
	}
}

function salvaPreferito(idRicetta) {
	

	const data = {
		grammiml: idRicetta,
	};

	fetch(endpointUrl, {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(data)
	});
}









